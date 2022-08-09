<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 8/8/2022
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet" href="mystyle.css">

    <style>html,
    body {
        height: 100%;
    }

    body {
        margin: 0;
        background: linear-gradient(45deg, #49a09d, #5f2c82);
        font-family: sans-serif;
        font-weight: 100;
    }

    .container {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    table {
        width: 800px;
        border-collapse: collapse;
        overflow: hidden;
        box-shadow: 0 0 20px rgba(0,0,0,0.1);
    }

    th,
    td {
        padding: 15px;
        background-color: rgba(255,255,255,0.2);
        color: #fff;
    }

    th {
        text-align: left;
    }

    thead {
    th {
        background-color: #55608f;
    }
    }

    tbody {
    tr {
    &:hover {
         background-color: rgba(255,255,255,0.3);
     }
    }
    td {
        position: relative;
    &:hover {
    &:before {
         content: "";
         position: absolute;
         left: 0;
         right: 0;
         top: -9999px;
         bottom: -9999px;
         background-color: rgba(255,255,255,0.2);
         z-index: -1;
     }
    }
    }
    }</style>
</head>
<body>
HTML LessResult Skip Results Iframe
EDIT ON
<div class="container">
    <form action="/students" method="get">
    <table>
        <thead>
        <tr>
            <th>Column 1</th>
            <th>Column 2</th>
            <th>Column 3</th>
            <th>Column 4</th>
            <th>Column 5</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Cell 1</td>
            <td>Cell 2</td>
            <td>Cell 3</td>
            <td>Cell 4</td>
            <td>Cell 5</td>
        </tr>
        <tr>
            <td>Cell 1</td>
            <td>Cell 2</td>
            <td>Cell 3</td>
            <td>Cell 4</td>
            <td>Cell 5</td>
        </tr>
        <tr>
            <td>Cell 1</td>
            <td>Cell 2</td>
            <td>Cell 3</td>
            <td>Cell 4</td>
            <td>Cell 5</td>
        </tr>
        <tr>
            <td>Cell 1</td>
            <td>Cell 2</td>
            <td>Cell 3</td>
            <td>Cell 4</td>
            <td>Cell 5</td>
        </tr>
        <tr>
            <td>Cell 1</td>
            <td>Cell 2</td>
            <td>Cell 3</td>
            <td>Cell 4</td>
            <td>Cell 5</td>
        </tr>
        </tbody>
    </table>

    </form>
</div>
<div class="wrapper">
    <section class="pagination">
        <button class="disabled">Prev</button>
        <div class="pagination-state">
            <span class="counter-current">1</span>
            <span class="pagination-separator">/</span>
            <span class="counter-total">4</span>
        </div>
        <button>Next</button>
    </section>
</div>



Resources1× 0.5× 0.25×Rerun

</body>
</html>
