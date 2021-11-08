package com.example.model

sealed class UiState {
    object Idle: UiState()
    object Loaded: UiState()
    object Retry: UiState()
}