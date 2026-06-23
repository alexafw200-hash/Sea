package com.sea.downloader.ui.state

/**
 * Sealed class representing all possible states of the download operation.
 * This drives the entire UI rendering pipeline and animations.
 *
 * States:
 * - [Idle]: No operation in progress, ready for user input
 * - [Fetching]: Fetching metadata from yt-dlp (initial phase)
 * - [Downloading]: Active download with progress tracking
 * - [Success]: Download completed successfully
 * - [Error]: Operation failed with error message
 */
sealed class DownloadState {
    data object Idle : DownloadState()
    data class Fetching(val message: String) : DownloadState()
    data class Downloading(
        val progress: Float,     // 0f to 1f
        val speed: String,       // e.g., "2.5 MB/s"
        val eta: String          // e.g., "2m 34s"
    ) : DownloadState()
    data object Success : DownloadState()
    data class Error(val error: String) : DownloadState()
}
