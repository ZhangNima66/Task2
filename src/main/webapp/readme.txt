1.
    数据库表设计
    //书籍的种类表
    create table mxz_category
    (
        id varchar(40) primary key,
        name varchar(40) not null unique,
        description varchar(255) comment
    );
     comment on table mxz_category is '书籍的种类表';
     comment on column mxz_category.id is '种类的id';
     comment on column mxz_category.name is '种类的名字';
     comment on column mxz_category.description is '种类的描述';

    create table mxz_book
    (
        id varchar(40) primary key,
        name varchar(40) not null unique,
        price decimal(8,2) not null,
        author varchar(40) not null,
        image varchar(255) not null,
        description varchar(255),
        category_id varchar(40),
        constraint mxz_category_id_FK foreign key(category_id) references mxz_category(id)
    );
    comment on table mxz_book is '书籍信息表';
    comment on column mxz_book.name is '书籍的名称';
    comment on column mxz_book.price is '书籍的价格';
    comment on column mxz_book.author is '书籍的作者';
    comment on column mxz_book.image is '书籍图片的存储文件名';
    comment on column mxz_book.description is '书籍的大概描述';
    comment on column mxz_book.category_id is '书籍的种类约束的id';
