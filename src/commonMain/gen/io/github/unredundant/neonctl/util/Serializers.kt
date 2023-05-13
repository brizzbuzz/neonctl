package io.github.unredundant.neonctl.util

import com.benasher44.uuid.uuidFrom
import java.util.UUID
import kotlin.Unit
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object UuidSerializer : KSerializer<UUID> {
  public override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("UUID",
      PrimitiveKind.STRING)

  public override fun deserialize(decoder: Decoder): UUID = uuidFrom(decoder.decodeString())

  public override fun serialize(encoder: Encoder, `value`: UUID): Unit {
    encoder.encodeString(value.toString())
  }
}
