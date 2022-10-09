# Autor: jandirodriguez
# language: es
Característica: Realizar compra en la plataforma
  Como usuario quiero agregar productos al carrito para poder realiar la compra

  @store
  Esquema del escenario: Realizar compra en la plataforma
    Dado que yo ingreso a la pagina automationpractice
    Cuando ingreso productos al carrito
      | producto1   | producto2   | producto3   |
      | <producto1> | <producto2> | <producto3> |
    Entonces verificaria que se agreguen todos correctamente para poder comprarlos
      | producto1   | producto2   | producto3   |
      | <producto1> | <producto2> | <producto3> |

    Ejemplos:
      | producto1 | producto2            | producto3             |
      | Blouse    | Printed Summer Dress | Printed Chiffon Dress |