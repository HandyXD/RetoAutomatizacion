# Autor: jandirodriguez
# language: es

Característica: Crear una reserva de usuario en el api
  Como usuario deseo crear una reserva en la plataforma

  @booking
  Esquema del escenario: Realizar una reserva exitosa en la plataforma
    Dado que yo deseo realizar una peticion con los siguientes datos
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Cuando realizo la peticion de reserva en la plataforma
    Entonces deberia ver la respuesta exitosa de la reserva realizada

    Ejemplos:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jandi     | Rold     | 321        | true        | 2020-10-15 | 2022-10-03 | Breakfast       |
