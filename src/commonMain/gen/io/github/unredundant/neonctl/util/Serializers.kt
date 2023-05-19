package io.github.unredundant.neonctl.util

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuidFrom
import kotlin.Number
import kotlin.Unit
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object UuidSerializer : KSerializer<Uuid> {
  public override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("UUID",
      PrimitiveKind.STRING)

  public override fun deserialize(decoder: Decoder): Uuid = uuidFrom(decoder.decodeString())

  public override fun serialize(encoder: Encoder, `value`: Uuid): Unit {
    encoder.encodeString(value.toString())
  }
}

public object NumberSerializer : KSerializer<Number> {
  public override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Number",
      PrimitiveKind.DOUBLE)

  public override fun deserialize(decoder: Decoder): Number = try {
    decoder.decodeInt()
  } catch (e: Exception) {
    decoder.decodeDouble()
  }

  public override fun serialize(encoder: Encoder, `value`: Number): Unit {
    encoder.encodeString(value.toString())
  }
}
