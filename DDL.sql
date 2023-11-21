-- DDL    
    --  CRIACAO TABELAS / CONSTRAINTS (NO FK)
        -- ####################################
        -- T_FIN_CADASTRO
        CREATE TABLE T_FIN_CADASTRO (
            id_usuario NUMBER(2) NOT NULL,
            nm_usuario VARCHAR2(60) NOT NULL,
            email_usuario VARCHAR2(60) NOT NULL,
            senha_usuario VARCHAR2(10) NOT NULL,
            dt_nascimento DATE NOT NULL,
            nr_cpf NUMBER(11) NULL,
            nm_conta_bancaria VARCHAR2(40) DEFAULT 'Minha Conta'
        );
        
        ALTER TABLE T_FIN_CADASTRO 
            ADD CONSTRAINT pk_t_fin_cadastro PRIMARY KEY (id_usuario);
         
        ALTER TABLE T_FIN_CADASTRO ADD CONSTRAINT un_t_fin_cadastro_nr_cpf
            UNIQUE (nr_cpf);
        
         ALTER TABLE T_FIN_CADASTRO ADD CONSTRAINT un_t_fin_cadastro_email_usuario
            UNIQUE (email_usuario);
            
        ALTER TABLE T_FIN_CADASTRO ADD CONSTRAINT ck_t_fin_cadastro_senha_usuario
            CHECK(LENGTH(senha_usuario) >= 5);
            
        CREATE SEQUENCE SQ_T_FIN_CADASTRO
        INCREMENT BY 1
        START WITH 1
        NOCACHE
        NOCYCLE;
        
        ALTER TABLE T_FIN_CADASTRO MODIFY (id_usuario DEFAULT SQ_T_FIN_CADASTRO.NEXTVAL); 
        
        -- ####################################
        
         -- ####################################
         -- T_FIN_ENDERECO
         CREATE TABLE T_FIN_ENDERECO (
            id_usuario NUMBER(2) NOT NULL,
            id_endereco NUMBER(2) NOT NULL,
            nm_pais VARCHAR2(30) NOT NULL,
            nm_estado VARCHAR2(30) NOT NULL,
            nm_cidade VARCHAR2(30) NOT NULL,
            nm_bairro VARCHAR2(30) NOT NULL,
            nm_rua VARCHAR2(30) NOT NULL
         );
         
         ALTER TABLE T_FIN_ENDERECO 
            ADD CONSTRAINT pk_t_fin_endereco PRIMARY KEY(id_usuario, id_endereco);
        
        CREATE SEQUENCE SQ_T_FIN_ENDERECO
        INCREMENT BY 1
        START WITH 1
        NOCACHE
        NOCYCLE;
        
        ALTER TABLE T_FIN_ENDERECO MODIFY (id_endereco DEFAULT SQ_T_FIN_ENDERECO.NEXTVAL);
              
    
        -- ####################################
        
         -- ####################################
         -- T_FIN_CELULAR
         CREATE TABLE T_FIN_CELULAR (
            id_usuario NUMBER(2) NOT NULL,
            nr_celular VARCHAR2(9) NOT NULL,
            nr_celular_ddd NUMBER(2) NOT NULL,
            nr_celular_ddi NUMBER(3) NOT NULL
         );
         
         ALTER TABLE T_FIN_CELULAR 
            ADD CONSTRAINT pk_t_fin_celular PRIMARY KEY(id_usuario, nr_celular);
        
        ALTER TABLE T_FIN_CELULAR ADD CONSTRAINT ck_t_fin_celular_nr_celular
            CHECK (LENGTH(nr_celular) = 9);
        
        
        
        -- ####################################
        
        -- ####################################
         -- T_FIN_OBJETIVO
         CREATE TABLE T_FIN_OBJETIVO (
            id_usuario NUMBER(2) NOT NULL,
            id_objetivo NUMBER(2) NOT NULL,
            dt_alcance  DATE NOT NULL,
            vl_objetivo NUMBER(15, 2) NOT NULL,
            ds_objetivo VARCHAR2(30) DEFAULT 'Meu Objetivo'
         );
         
        CREATE SEQUENCE SQ_T_FIN_OBJETIVO
        INCREMENT BY 1
        START WITH 1
        NOCACHE
        NOCYCLE;
        
        ALTER TABLE T_FIN_OBJETIVO MODIFY (id_objetivo DEFAULT SQ_T_FIN_OBJETIVO.NEXTVAL);
         
        ALTER TABLE T_FIN_OBJETIVO
                ADD CONSTRAINT pk_t_fin_objetivo PRIMARY KEY(id_usuario, id_objetivo);
        -- ####################################
        
        -- ####################################
         -- T_FIN_RENDIMENTO
         CREATE TABLE T_FIN_RENDIMENTO (
            id_usuario NUMBER(2) NOT NULL,
            id_rendimento NUMBER(2) NOT NULL,
            vl_rendimento NUMBER(9, 2) NOT NULL,
            nm_rendimento VARCHAR2(20) NOT NULL,
            ds_rendimento VARCHAR2(30) NOT NULL,
            dt_rendimento DATE NOT NULL
         );
         
         ALTER TABLE T_FIN_RENDIMENTO
                ADD CONSTRAINT pk_t_fin_rendimento PRIMARY KEY(id_usuario, id_rendimento);
        
        CREATE SEQUENCE SQ_T_FIN_RENDIMENTO
        INCREMENT BY 1
        START WITH 1
        NOCACHE
        NOCYCLE;
        
        ALTER TABLE T_FIN_RENDIMENTO MODIFY (id_rendimento DEFAULT SQ_T_FIN_RENDIMENTO.NEXTVAL);
        -- ####################################
        
        -- ####################################
         -- T_FIN_DESPESA
         CREATE TABLE T_FIN_DESPESA (
            id_usuario NUMBER(2) NOT NULL,
            id_despesa NUMBER(2) NOT NULL,
            vl_despesa NUMBER(9, 2) NOT NULL,
            nm_despesa VARCHAR2(20) NOT NULL,
            ds_despesa VARCHAR2(30) NOT NULL,
            dt_despesa DATE NOT NULL       
         );
    
         ALTER TABLE T_FIN_DESPESA
                ADD CONSTRAINT pk_t_fin_despesa PRIMARY KEY(id_usuario, id_despesa);
        
        CREATE SEQUENCE SQ_T_FIN_DESPESA
        INCREMENT BY 1
        START WITH 1
        NOCACHE
        NOCYCLE;
        
        ALTER TABLE T_FIN_DESPESA MODIFY (id_despesa DEFAULT SQ_T_FIN_DESPESA.NEXTVAL);
       -- ####################################
        
        -- ####################################
         -- T_FIN_RECEBIMENTO            
         CREATE TABLE T_FIN_RECEBIMENTO (
            id_usuario NUMBER(2) NOT NULL,
            id_recebimento NUMBER(2) NOT NULL,
            vl_recebimento NUMBER(9, 2) NOT NULL,
            nm_recebimento VARCHAR2(20) NOT NULL,
            ds_recebimento VARCHAR2(30) NOT NULL,
            dt_recebimento DATE NOT NULL      
         );
        

         ALTER TABLE T_FIN_RECEBIMENTO
                ADD CONSTRAINT pk_t_fin_recebimento PRIMARY KEY(id_usuario, id_recebimento);
        
        CREATE SEQUENCE SQ_T_FIN_RECEBIMENTO
        INCREMENT BY 1
        START WITH 1
        NOCACHE
        NOCYCLE;
        
        ALTER TABLE T_FIN_RECEBIMENTO MODIFY (id_recebimento DEFAULT SQ_T_FIN_RECEBIMENTO.NEXTVAL);
    
       -- ####################################
       
    --  CRIACAO CHAVES ESTRANGEIRAS
    ALTER TABLE T_FIN_ENDERECO ADD CONSTRAINT fk_t_fin_endereco FOREIGN KEY(id_usuario) REFERENCES T_FIN_CADASTRO(id_usuario);
    ALTER TABLE T_FIN_CELULAR ADD CONSTRAINT fk_t_fin_celular FOREIGN KEY(id_usuario) REFERENCES T_FIN_CADASTRO(id_usuario);
    ALTER TABLE T_FIN_OBJETIVO ADD CONSTRAINT fk_t_fin_objetivo FOREIGN KEY(id_usuario) REFERENCES T_FIN_CADASTRO(id_usuario);
    ALTER TABLE T_FIN_RENDIMENTO ADD CONSTRAINT fk_t_fin_rendimento FOREIGN KEY(id_usuario) REFERENCES T_FIN_CADASTRO(id_usuario);
    ALTER TABLE T_FIN_DESPESA ADD CONSTRAINT fk_t_fin_despesa FOREIGN KEY(id_usuario) REFERENCES T_FIN_CADASTRO(id_usuario);
    ALTER TABLE T_FIN_RECEBIMENTO ADD CONSTRAINT fk_t_fin_recebimento FOREIGN KEY(id_usuario) REFERENCES T_FIN_CADASTRO(id_usuario);
    
