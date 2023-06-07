var express = require("express");
var router = express.Router();

var lucroController = require("../controllers/lucroController");

router.get("/", function (req, res) {
    lucroController.testar(req, res);
});

router.get("/listar", function (req, res) {
    lucroController.listar(req, res);
});

//Recebendo os dados do html e direcionando para a função cadastrar de lucroController.js
router.post("/cadastrar", function (req, res) {
    lucroController.cadastrar(req, res);
})

router.post("/autenticar", function (req, res) {
    lucroController.entrar(req, res);
});

module.exports = router;