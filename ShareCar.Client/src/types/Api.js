// @flow

type ApiError = {
    code: number,
    text: string
}

// type ApiResponse<T> = T | ApiError;
type ApiResponse<T> = {isError: false, value: T} | {isError: true, value: ApiError};