CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `primeiro_nome` varchar(80) NOT NULL,
  `ultimo_nome` varchar(80) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `genero` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
)
