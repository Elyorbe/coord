package com.musinsa.coord.catalog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Seed data is used from resources/db/migration/V0_0_2__seed_data.sql
@SpringBootTest
@AutoConfigureMockMvc
class CatalogIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET /api/v1/catalog/cheapest-per-category")
    class CheapestPerCategoryTests {

        @Test
        @DisplayName("should return 8 cheapest products by category and correct total price")
        void testFetchCheapestPerCategory() throws Exception {
            mockMvc.perform(get("/api/v1/catalog/cheapest-per-category")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    // Check that we have 8 selections (one for each category)
                    .andExpect(jsonPath("$.selections", hasSize(8)))
                    // Verify each selection based on our seed computations:
                    // Expected results:
                    // 상의: Brand C, 10000
                    .andExpect(jsonPath("$.selections[?(@.category=='상의')].brand", hasItem("C")))
                    .andExpect(jsonPath("$.selections[?(@.category=='상의')].price", hasItem(10000)))
                    // 아우터: Brand E, 5000
                    .andExpect(jsonPath("$.selections[?(@.category=='아우터')].brand", hasItem("E")))
                    .andExpect(jsonPath("$.selections[?(@.category=='아우터')].price", hasItem(5000)))
                    // 바지: Brand D, 3000
                    .andExpect(jsonPath("$.selections[?(@.category=='바지')].brand", hasItem("D")))
                    .andExpect(jsonPath("$.selections[?(@.category=='바지')].price", hasItem(3000)))
                    // 스니커즈: Brand A, 9000
                    .andExpect(jsonPath("$.selections[?(@.category=='스니커즈')].brand", hasItem("A")))
                    .andExpect(jsonPath("$.selections[?(@.category=='스니커즈')].price", hasItem(9000)))
                    // 가방: Brand A, 2000
                    .andExpect(jsonPath("$.selections[?(@.category=='가방')].brand", hasItem("A")))
                    .andExpect(jsonPath("$.selections[?(@.category=='가방')].price", hasItem(2000)))
                    // 모자: Brand D, 1500
                    .andExpect(jsonPath("$.selections[?(@.category=='모자')].brand", hasItem("D")))
                    .andExpect(jsonPath("$.selections[?(@.category=='모자')].price", hasItem(1500)))
                    // 양말: Brand I, 1700
                    .andExpect(jsonPath("$.selections[?(@.category=='양말')].brand", hasItem("I")))
                    .andExpect(jsonPath("$.selections[?(@.category=='양말')].price", hasItem(1700)))
                    // 액세서리: Brand F, 1900
                    .andExpect(jsonPath("$.selections[?(@.category=='액세서리')].brand", hasItem("F")))
                    .andExpect(jsonPath("$.selections[?(@.category=='액세서리')].price", hasItem(1900)))
                    // Verify the total price sum: expected 34100.
                    .andExpect(jsonPath("$.totalPrice", is(34100)));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/catalog/cheapest-total-brand")
    class CheapestTotalBrandTests {

        @Test
        @DisplayName("should return the brand with the lowest sum of prices and category details")
        void testFetchCheapestTotalBrand() throws Exception {
            // Based on our seed data, the brand with the lowest total is D with total = 36100.
            mockMvc.perform(get("/api/v1/catalog/cheapest-total-brand")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    // Verify that the returned brand is "D" and totalPrice equals 36100.
                    .andExpect(jsonPath("$.minPrice.brand", is("D")))
                    .andExpect(jsonPath("$.minPrice.totalPrice", is(36100)))
                    // Verify the categoryPrices list is 8 items long.
                    .andExpect(jsonPath("$.minPrice.categoryPrices", hasSize(8)))
                    // For category "상의" expect price 10100 and for "바지" expect price 3000.
                    .andExpect(jsonPath("$.minPrice.categoryPrices[?(@.category=='상의')].price", hasItem(10100)))
                    .andExpect(jsonPath("$.minPrice.categoryPrices[?(@.category=='바지')].price", hasItem(3000)));
        }
    }

    @Nested
    @DisplayName("GET /api/v1/catalog/min-max-prices")
    class MinMaxPricesTests {

        @Test
        @DisplayName("should return min and max price products for category '상의'")
        void testFetchMinMaxPricesForValidCategory() throws Exception {
            // For category "상의":
            // Expected min = 10000 (Brand C) and max = 11400 (Brand I)
            mockMvc.perform(get("/api/v1/catalog/min-max-prices")
                            .param("categoryName", "상의")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    // Check the response has the correct category name.
                    .andExpect(jsonPath("$.categoryName", is("상의")))
                    // Verify that minPrice list is not empty and each returned product has price equal to 10000.
                    .andExpect(jsonPath("$.minPrice", not(empty())))
                    .andExpect(jsonPath("$.minPrice[*].price", everyItem(is(10000))))
                    // And that the brand in the minPrice list is "C"
                    .andExpect(jsonPath("$.minPrice[*].brandName", hasItem("C")))
                    // Verify that maxPrice list is not empty and each returned product has price equal to 11400.
                    .andExpect(jsonPath("$.maxPrice", not(empty())))
                    .andExpect(jsonPath("$.maxPrice[*].price", everyItem(is(11400))))
                    // And that the brand in the maxPrice list is "I"
                    .andExpect(jsonPath("$.maxPrice[*].brandName", hasItem("I")));
        }

        @Test
        @DisplayName("should return 404 NOT FOUND when non-existent category is specified")
        void testFetchMinMaxPricesCategoryNotFound() throws Exception {
            mockMvc.perform(get("/api/v1/catalog/min-max-prices")
                            .param("categoryName", "NonExistentCategory")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.message", containsString("doesn't exist")));
        }

        @Test
        @DisplayName("should return 400 BAD REQUEST when categoryName parameter is empty")
        void testFetchMinMaxPricesEmptyCategory() throws Exception {
            mockMvc.perform(get("/api/v1/catalog/min-max-prices")
                            .param("categoryName", "")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.additionalMessage", containsString("categoryName parameter cannot be empty or null")));
        }
    }

}
