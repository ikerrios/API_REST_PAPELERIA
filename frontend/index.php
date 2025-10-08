<?php
    $url = "http://localhost:8080/api/articulos";
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
                    <td>price</td>
                    <td>stock</td>
                    <td>category</td>
                </tr>
            </thead>
            <tbody>
                <?php foreach($articulos as $articulo): ?>
                    <tr>
                        <td><?php echo $articulo['id'] ?></td>
                        <td><?php echo $articulo['name'] ?></td>
                        <td><?php echo $articulo ['price'] ?></td>
                        <td><?php echo $articulo ['stock'] ?></td>
                        <td><?php echo $articulo ['category'] ?></td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </body> 
</html>