<?php
    $url = "https://localhost:8080/articulos" //terminar esta línea.
    $data = file_get_contents($url);
    $articulos = json_decode($data, true);

    //var_dump($articulos)
?>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <title>Listado de artículos</title>
    </head>
    <body>
        <table class="table table-striped">
                <thead>
                <h1>Listado de artículos</h1>
                    <tr>
                        <td>ID</td>
                        <td>name</td>
                        <td>chip</td>
                        <td>category</td>
                        <td>born</td>
                        <td>adopt</td>
                    </tr>
                </thead>
                <!--Continuar--> 