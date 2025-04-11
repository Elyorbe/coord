package com.musinsa.coord.common.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonMixin;
import org.springframework.data.domain.PageImpl;

/**
 * Mixin for renaming or ignoring properties
 * during serialization of {@link PageImpl}
 * <br><br>
 * Ignored properties:
 * <ul>
 * <li>pageable
 * <li>numberOfElements
 * <li>empty
 * </ul>
 * Renamed properties:
 * <ul>
 * <li>number -> page
 * <ul/>
 * */
@JsonIgnoreProperties({ "pageable", "numberOfElements", "empty" })
@JsonMixin(PageImpl.class)
public abstract class PageImplMixIn {

    int number;

    @JsonProperty("page")
    public int getNumber() {
        return number;
    }

}
