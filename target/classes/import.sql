/*Lanches*/
insert into tb_lanche(id, nome_lanche) values (1, 'X-Bacon');
insert into tb_lanche(id, nome_lanche) values (2, 'X-Burger');
insert into tb_lanche(id, nome_lanche) values (3, 'X-Egg');
insert into tb_lanche(id, nome_lanche) values (4, 'X-Egg Bacon');
commit;

/*Ingredientes*/
insert into tb_ingrediente(id, descricao, preco) values (1, 'Alface', 0.40);
insert into tb_ingrediente(id, descricao, preco) values (2, 'Bacon', 2.00);
insert into tb_ingrediente(id, descricao, preco) values (3, 'Hamburguer Carne', 3.00);
insert into tb_ingrediente(id, descricao, preco) values (4, 'Ovo', 0.80);
insert into tb_ingrediente(id, descricao, preco) values (5, 'Queijo', 1.50);
commit;

/*X-Bacon*/
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (1, 3, 1);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (2, 2, 1);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (3, 5, 1);

/*X-Burger*/
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (4, 3, 2);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (5, 5, 2);

/*X-Egg*/
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (6, 3, 3);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (7, 4, 3);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (8, 5, 3);

/*X-Egg Bacon*/
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (9, 2, 4);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (10, 3, 4);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (11, 4, 4);
insert into tb_ingrediente_lanche(id, id_ingrediente, id_lanche) values (12, 5, 4);
commit;