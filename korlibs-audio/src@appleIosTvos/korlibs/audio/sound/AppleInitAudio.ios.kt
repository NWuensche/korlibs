@file:OptIn(ExperimentalForeignApi::class)

package korlibs.audio.sound

import kotlinx.cinterop.*
import platform.AVFAudio.*
import platform.Foundation.*

internal actual val appleInitAudioOnce: Unit by lazy {
    memScoped {
        val error = alloc<ObjCObjectVar<NSError?>>().ptr
        //AVAudioSession.sharedInstance().setCategory(AVAudioSessionCategoryPlayback, error) // Stops Music apps, etc.
        //AVAudioSession.sharedInstance().setCategory(AVAudioSessionCategorySoloAmbient, error)
        AVAudioSession.sharedInstance().setCategory(AVAudioSessionCategoryAmbient, error)
        //AVAudioSessionCategoryOptionMixWithOthers
        AVAudioSession.sharedInstance().setActive(true, error)
    }
    Unit
}
