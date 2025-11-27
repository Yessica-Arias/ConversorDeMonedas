💱 Conversor de Monedas en Java

Este proyecto es un conversor de monedas desarrollado en Java como parte del aprendizaje de programación en Alura LATAM.
El programa permite convertir entre distintas monedas utilizando una API de tasas de cambio en tiempo real.

🚀 Funcionalidades

Menú interactivo en consola.

Conversión entre:

🇺🇸 USD ⇄ 🇦🇷 ARS
🇺🇸 USD ⇄ 🇧🇷 BRL
🇺🇸 USD ⇄ 🇨🇴 COP

- Consulta de tasas actualizadas usando ExchangeRate API.
- Conversión directa e inversa.
- Repetición del menú hasta que el usuario decida salir.

🧠 Lógica del programa

El proyecto se divide en tres partes principales:

1️⃣ CrearHttp

Clase encargada de:

- Conectarse a la API.
- Obtener la tasa de cambio según el par de monedas.
- Manejar errores de conexión.

2️⃣ Conversor

Contiene los métodos:

- convertir → para conversión directa (ej: USD → ARS).
- convertirInverso → para conversión inversa (ej: ARS → USD).

Ambos usan la tasa obtenida de la API.

3️⃣ Menú principal

- Muestra las 7 opciones.
- Lee el valor ingresado.
- Llama al método correcto según el caso.
- Permite que el menú se repita con un while hasta que el usuario elija 7. Salir.

🛠️ Tecnologías Utilizadas

- Java 17+
- Gson para parseo JSON.
- ExchangeRate API


🙌 Autora

Proyecto realizado por Jessica, como parte de su proceso de aprendizaje en programación.
