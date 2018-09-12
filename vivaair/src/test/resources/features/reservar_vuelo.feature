#Author: estefa.bernal@tcs.com
Feature: Reserva de vuelo
  Como comprador deseo reservar y adquirir un vuelo

  @ReservaExitosa
  Scenario: Reservar un vuelo
    When deseo reservar un vuelo ingreso los datos para realizarlo
      | fecha_ida  | fecha_regreso | ciudad_origen | ciudad_destino | cantidad_adultos | cantidad_ninos | cantidad_infantes | tipo_moneda |
      | 30/08/2018 | 29/10/2018   | Medellin      | Bogota         |                1 |              1 |                 0 | COP         |
    And deseo reservar el vuelo de ida con el precio mas barato y el de regreso con el mas costoso
    And deseo ingresar los datos de todos los pasajeros
      | nombre | apellidos     | genero    | identificacion | asistencia | correo           | celular    |
      | Jose   | Perez Marquez | Femenino  |          12439 | NO         | estefa@gmail.com | 3137658163 |
      | Maria  | Zapata        | Masculino |           8607 | NO         |                  |            |
    Then podre exportar y visualizar los datos de mi vuelo
