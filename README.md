# PROYECTO-1
                                                        
Proyecto 1

Puedes hacer pruebas con el proyecto si tienes docker

windows
docker pull 2023hersonvega922/bolsa:latest

linux
sudo docker pull 2023hersonvega922/bolsa:latest

Para ejecutarlo

Windows
Si tienes docker desktop ya te va a aparecer el contenedor y solo con darle click en ejecutar ya lo tendras en produccion

Ubuntu
Desde la carpeta donde tienes el contenedor ejecuta el siguiente comando
sudo docker run -p 8090:8090 bolsa
-> el 8090 se refiere al puerto del contenedor
-> el siguiente 8090 se refiere al puerto del servidor donde se encuentra el contenedor
Se pueden cambiar el 8090 solo es demostrativo

Rutas sugeridas: Escribe 0.0.0.0:8090/swagger-ui/index.html
Encontrarás todas las rutas de la API
Por razones de seguridad solo estan habilitadas las de consulta



Para verlo en el navegador tendras que usar el siguiente url
0.0.0.0:8090/admin/consultarTodo

Donde 0.0.0.0 sera la ip de la maquina donde se ejecuta el contenedor
8090 es el puerto usado
admin es de del controlador puede ser cualquier controlador
consultarTodo devuelve una lista de empresas con ofertas

