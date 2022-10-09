# Autor: jandirodriguez
# language: es

Característica: Actualizacion de una reserva de usuario en el api
  Como usuario deseo actualizar una reserva en la plataforma

  @booking
  Esquema del escenario: Realizar una actualizacion de datos exitosa de una reserva en la plataforma
    Dado que yo deseo realizar una peticion con los siguientes datos
      | id   | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <id> | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Cuando realizo la acutalizacion de una reserva en get booking
    Entonces deberia ver la respuesta exitosa de la actualizacion realizada en update booking

    Ejemplos:
      | id | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | 7  | Jean      | Red      | 888        | true        | 2021-02-20 | 2021-08-17 | Breakfast       |
