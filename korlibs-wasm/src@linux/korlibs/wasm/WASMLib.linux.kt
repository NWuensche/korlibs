package korlibs.wasm

actual open class WASMLib actual constructor(content: ByteArray) : IWASMLib by DefaultNativeWASMLib(content)

open class DefaultNativeWASMLib(content: ByteArray) : IWASMLib, BaseWASMLib(content)
