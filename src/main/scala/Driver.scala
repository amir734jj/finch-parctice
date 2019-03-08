import com.twitter.finagle.Http
import com.twitter.util.Await

import io.finch._
import io.finch.circe._
import io.finch.syntax._
import io.circe.generic.auto._

object Main extends App {

  val foo =
    get("foo") {
      Ok("Foo!")
    }

  val bar =
    get("bar") {
      Ok("Bar!")
    }

  val index =
    get(/) {
      Ok("Hello world!")
    }

  Await.ready(Http.server.serve(":80", (foo :+: bar :+: index).toService))
}