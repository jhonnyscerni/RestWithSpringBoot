CREATE TABLE `livro` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `autor` longtext,
  `data_lancamento` datetime(6) NOT NULL,
  `preco` decimal(65,2) NOT NULL,
  `titulo` longtext
)
