# Autor: jandirodriguez
# language: es

Característica: Consulta de una reserva de usuario en el api
  Como usuario deseo consultar una reserva en la plataforma

  @booking
  Esquema del escenario: Realizar una consulta exitosa de una reserva en la plataforma
    Dado que yo deseo realizar una peticion con los siguientes datos
      | id   | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <id> | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Cuando realizo la peticion para consultar una reserva en get booking
    Entonces deberia ver la respuesta exitosa de la consulta realizada en get booking

    Ejemplos:
      | id | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | 7  | Jean      | Red      | 888        | true        | 2021-02-20 | 2021-08-17 | Breakfast       |
