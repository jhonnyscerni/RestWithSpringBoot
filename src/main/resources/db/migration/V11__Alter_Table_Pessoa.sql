ALTER TABLE `Pessoa`
	ADD COLUMN `enabled` BIT(1) NOT NULL DEFAULT 1 AFTER `ultimo_nome`;
