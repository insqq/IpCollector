package controllers

import java.time.LocalDateTime

import play.api.mvc._

object Application extends Controller {

  val ips = scala.collection.mutable.LinkedHashMap.empty[LocalDateTime, String]

  def index = Action { request =>
    ips.put(LocalDateTime.now(), request.remoteAddress)
    Ok("sorry, site is under maintenance, please come back later")
  }

  def fetchIps = Action { request =>
    Ok(ips.mkString("\n"))
  }
}