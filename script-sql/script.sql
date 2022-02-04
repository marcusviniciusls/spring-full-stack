-- Inserção script Initialazer

-- Inserção Categorias
INSERT INTO category (uuid, date_creation, status, nome) 
VALUES ('bae68253-3f14-485b-b7a2-072bf0225b1b','2022-02-04 15:28:19.324474', true, 'Informática');
INSERT INTO category (uuid, date_creation, status, nome) 
VALUES ('bae68253-3f14-485b-b7a2-072bf0225b11','2022-02-04 15:28:19.324474', true, 'Cameras');
INSERT INTO category (uuid, date_creation, status, nome) 
VALUES ('bae68253-3f14-485b-b7a2-072bf0225b12','2022-02-04 15:28:19.324474', true, 'Insumos');
INSERT INTO category (uuid, date_creation, status, nome) 
VALUES ('bae68253-3f14-485b-b7a2-072bf0225b13','2022-02-04 15:28:19.324474', true, 'Automotivel');
INSERT INTO category (uuid, date_creation, status, nome) 
VALUES ('bae68253-3f14-485b-b7a2-072bf0225b16','2022-02-04 15:28:19.324474', true, 'Móveis');


-- Inserção de Produtos
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e06b','2022-02-04 15:28:19.324474', true, 'Computador Positivo','900.0','bae68253-3f14-485b-b7a2-072bf0225b1b','1');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e061','2022-02-04 15:28:19.324474', true, 'Computador Dell','700.0','bae68253-3f14-485b-b7a2-072bf0225b1b','2');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e062','2022-02-04 15:28:19.324474', true, 'Fiat Pulo','40000.0','bae68253-3f14-485b-b7a2-072bf0225b13','3');
INSERT INTO Product (uuid, date_creation, sttus, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e064','2022-02-04 15:28:19.324474', true, 'Caneta BIC','1.0','bae68253-3f14-485b-b7a2-072bf0225b12','4');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e065','2022-02-04 15:28:19.324474', true, 'POST IT','0.5','bae68253-3f14-485b-b7a2-072bf0225b12','5');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e066','2022-02-04 15:28:19.324474', true, 'Lápis de Cor','10.0','bae68253-3f14-485b-b7a2-072bf0225b12','6');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e06b7','2022-02-04 15:28:19.324474', true, 'Tablet','700.0','bae68253-3f14-485b-b7a2-072bf0225b1b','7');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e06b8','2022-02-04 15:28:19.324474', true, 'MacBook Pro','20000.0','bae68253-3f14-485b-b7a2-072bf0225b1b','8');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e06b9','2022-02-04 15:28:19.324474', true, 'IPhone','700.0','bae68253-3f14-485b-b7a2-072bf0225b1b','9');
INSERT INTO Product (uuid, date_creation, status, nome, price, category_id, cody_product) 
VALUES ('6ef538ab-3f09-42a2-9029-7385a3c5e0610','2022-02-04 15:28:19.324474', true, 'Camera Sony','700.0','bae68253-3f14-485b-b7a2-072bf0225b11','10');


-- Inserção Estados
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Acre','AC','12') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Alagoas','AL','27') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Amazonas','AM','13') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Amapá','AP','16') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Bahia','BA','29') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Ceará','CE','23') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Distrito Federal','DF','53') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Espirito Santo','ES','32') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Goiás','GO','52') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Maranhão','MA','21') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Mato Grosso','MT','51') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Mato Grosso do Sul','MS','50') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Minas Gerais','MG','31') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Pará','PA','15') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Paraíba','PB','25') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Paraná','PR','41') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Pernanbuco','PE','26') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Piauí','PI','22') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Rio de Janeiro','RJ','33') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Rio Grande do Norte','RN','24') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Rio Grande do Sul','RS','43') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Rondônia','RO','11') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Roraima','RR','14') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Santa Catarina','SC','42') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'São Paulo','SP','35') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Sergipe','SE','29') 
INSERT INTO State (uuid, date_creation, status, name, uf, code)
VALUES ('abec70b9-dd4f-4038-82cc-b73d511d8072','2022-02-04 15:28:19.324474', true, 'Tocatins','TO','17')