package com.musinsa.coord.common.api;

public record WriteResultResponse(
        boolean success,
        String message,
        Long id
) {
    public static WriteResultResponse created(Long id) {
        return new WriteResultResponse(true, "Created successfully", id);
    }

    public static WriteResultResponse updated(Long id) {
        return new WriteResultResponse(true, "Updated successfully", id);
    }

    public static WriteResultResponse deleted(Long id) {
        return new WriteResultResponse(true, "Deleted successfully", id);
    }

}
