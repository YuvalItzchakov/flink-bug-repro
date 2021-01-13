package org.yuvalitzchakov.bugrepro

import com.esotericsoftware.kryo.io.{ Input, Output }
import com.esotericsoftware.kryo.{ Kryo, Serializer }
import io.circe.Json
import io.circe.parser._

final class JsonKryoSerializer extends Serializer[Json](true, true) with Serializable {
  override def write(kryo: Kryo, output: Output, `object`: Json): Unit =
    output.writeString(`object`.noSpaces)

  override def read(kryo: Kryo, input: Input, `type`: Class[Json]): Json =
    parse(input.readString()) match {
      case Left(err) =>
        throw err
      case Right(value) => value
    }

  override def copy(kryo: Kryo, original: Json): Json =
    parse(original.spaces2) match {
      case Left(err)    => throw err
      case Right(value) => value
    }
}
