create table clients (
            id serial,
            uid int not null unique,
            name varchar(50),
            address varchar(50),
            age int not null,
            
            constraint pk_clients_id primary key(id)
            );

create table bills (
            id serial,
            uid int not null unique,
            clientid int not null,
            total numeric(10, 2),

            constraint pk_bills_id primary key(id),
            constraint fk_bills_clients foreign key(clientid)
            references clients(id)
            );

create table transactions (
            id serial,
            fromBill int,
            toBill int not null,
            sum numeric(10, 2),
            dateTransaction timestamp(0),
            descriptions varchar(50),

            constraint pk_transactions_id primary key(id),
            constraint fk_transactions_bills1 foreign key(fromBill)
            references bills(id),
            constraint fk_transactions_bills2 foreign key(toBill)
            references bills(id)
            );

insert into clients(uid, name, address, age)
      values(1, 'name1', 'address1', 20);
insert into clients(uid, name, address, age)
      values(2, 'name2', 'address2', 21);
insert into clients(uid, name, address, age)
      values(3, 'name3', 'address3', 22);
insert into clients(uid, name, address, age)
      values(4, 'name4', 'address4', 23);
insert into clients(uid, name, address, age)
      values(5, 'name5', 'address5', 24);
insert into clients(uid, name, address, age)
      values(6, 'name6', 'address6', 25);
insert into clients(uid, name, address, age)
      values(7, 'name7', 'address7', 26);
insert into clients(uid, name, address, age)
      values(8, 'name8', 'address8', 27);
insert into clients(uid, name, address, age)
      values(9, 'name9', 'address9', 28);
insert into clients(uid, name, address, age)
      values(10, 'name10', 'address10', 29);
insert into clients(uid, name, address, age)
      values(11, 'name11', 'address11', 30);
insert into clients(uid, name, address, age)
      values(12, 'name12', 'address12', 20);
insert into clients(uid, name, address, age)
      values(13, 'name13', 'address13', 21);
insert into clients(uid, name, address, age)
      values(14, 'name14', 'address14', 22);
insert into clients(uid, name, address, age)
      values(15, 'name15', 'address15', 23);
insert into clients(uid, name, address, age)
      values(16, 'name16', 'address16', 24);
insert into clients(uid, name, address, age)
      values(17, 'name17', 'address17', 25);
insert into clients(uid, name, address, age)
      values(18, 'name18', 'address18', 26);
insert into clients(uid, name, address, age)
      values(19, 'name19', 'address19', 27);
insert into clients(uid, name, address, age)
      values(20, 'name20', 'addres20', 28);
insert into clients(uid, name, address, age)
      values(21, 'name22', 'address21', 29);
insert into clients(uid, name, address, age)
      values(22, 'name23', 'address22', 30);
insert into clients(uid, name, address, age)
      values(23, 'name24', 'address23', 20);
insert into clients(uid, name, address, age)
      values(24, 'name25', 'address24', 21);
insert into clients(uid, name, address, age)
      values(25, 'name26', 'address25', 22);
insert into clients(uid, name, address, age)
      values(26, 'name27', 'address26', 23);
insert into clients(uid, name, address, age)
      values(27, 'name28', 'address27', 24);
insert into clients(uid, name, address, age)
      values(28, 'name29', 'address28', 25);
insert into clients(uid, name, address, age)
      values(29, 'name30', 'address29', 26);
insert into clients(uid, name, address, age)
      values(30, 'name31', 'address30', 27);


insert into bills(uid, clientid, total)
      values(1, 1, 1000.00);
insert into bills(uid, clientid, total)
      values(2, 1, 1000.00);
insert into bills(uid, clientid, total)
      values(3, 1, 1000.00);
insert into bills(uid, clientid, total)
      values(4, 1, 1000.00);
insert into bills(uid, clientid, total)
      values(5, 1, 1000.00);
insert into bills(uid, clientid, total)
      values(6, 2, 2000.00);
insert into bills(uid, clientid, total)
      values(7, 2, 2000.00);
insert into bills(uid, clientid, total)
      values(8, 2, 2000.00);
insert into bills(uid, clientid, total)
      values(9, 2, 2000.00);
insert into bills(uid, clientid, total)
      values(10, 2, 2000.00);
insert into bills(uid, clientid, total)
      values(11, 3, 3000.00);
insert into bills(uid, clientid, total)
      values(12, 3, 3000.00);
insert into bills(uid, clientid, total)
      values(13, 3, 3000.00);
insert into bills(uid, clientid, total)
      values(14, 4, 4000.00);
insert into bills(uid, clientid, total)
      values(15, 5, 5000.00);
insert into bills(uid, clientid, total)
      values(16, 5, 5000.00);
insert into bills(uid, clientid, total)
      values(17, 5, 5000.00);
insert into bills(uid, clientid, total)
      values(18, 5, 5000.00);
insert into bills(uid, clientid, total)
      values(19, 6, 6000.00);
insert into bills(uid, clientid, total)
      values(20, 7, 7000.00);
insert into bills(uid, clientid, total)
      values(21, 7, 7000.00);
insert into bills(uid, clientid, total)
      values(22, 7, 7000.00);
insert into bills(uid, clientid, total)
      values(23, 7, 7000.00);
insert into bills(uid, clientid, total)
      values(24, 8, 8000.00);
insert into bills(uid, clientid, total)
      values(25, 8, 8000.00);
insert into bills(uid, clientid, total)
      values(26, 8, 8000.00);
insert into bills(uid, clientid, total)
      values(27, 8, 8000.00);
insert into bills(uid, clientid, total)
      values(28, 9, 9000.00);
insert into bills(uid, clientid, total)
      values(29, 10, 10000.00);
insert into bills(uid, clientid, total)
      values(30, 10, 10000.00);