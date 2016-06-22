/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  08/04/2016 16:35:16                      */
/*==============================================================*/


drop table if exists ACTION;

drop table if exists APPARTIENT;

drop table if exists USERS;

drop table if exists USER_ROLES;

drop table if exists CALENDRIER;

drop table if exists EST_ASSOCIE;

drop table if exists FIXE;

drop table if exists INDICATEUR;

drop table if exists JEU;

drop table if exists MISSION;

drop table if exists OBJECTIF;

drop table if exists OBTIENT;

drop table if exists POSSEDE;

drop table if exists REGLE;

/*==============================================================*/
/* Table : ACTION                                               */
/*==============================================================*/
create table ACTION
(
   NUMACTION            int not null,
   ACT_NUMACTION        int,
   LIBACTION            char(25),
   SCOREMIN             int,
   primary key (NUMACTION)
);

/*==============================================================*/
/* Table : COMPREND                                           */
/*==============================================================*/
create table COMPREND
(
   NUMJEU               int not null,
   NUMMISSION            int not null,
   primary key (NUMJEU, NUMMISSION)
);

/*==============================================================*/
/* Table : USERS                                            */
/*==============================================================*/
create table USERS
(
   IDUSERS int not null AUTO_INCREMENT,
   USERNAME varchar(45) NOT NULL,
   NOMUSERS char(25),
   PRENOMUSERS char(25),
   PASSWORD varchar(45) NOT NULL,
   ENABLED TINYINT NOT NULL DEFAULT 1,
   primary key (IDUSERS)
);

/*==============================================================*/
/* Table : USER_ROLES                                           */
/*==============================================================*/
CREATE TABLE USER_ROLES (
  USER_ROLE_ID int(11) NOT NULL AUTO_INCREMENT,
  USER_ID int NOT NULL,
  ROLE varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,USER_ID),
  KEY fk_username_idx (USER_ID),
  CONSTRAINT fk_username FOREIGN KEY (USER_ID) REFERENCES USERS (IDUSERS));


/*==============================================================*/
/* Table : CALENDRIER                                           */
/*==============================================================*/
create table CALENDRIER
(
   DATEJOUR             date not null,
   primary key (DATEJOUR)
);

/*==============================================================*/
/* Table : EST_ASSOCIE                                          */
/*==============================================================*/
create table EST_ASSOCIE
(
   NUMACTION            int not null,
   NUMOBJECTIF          int not null,
   primary key (NUMACTION, NUMOBJECTIF)
);

/*==============================================================*/
/* Table : FIXE                                                 */
/*==============================================================*/
create table FIXE
(
   NUMMISSION           int not null,
   NUMOBJECTIF          int not null,
   primary key (NUMMISSION, NUMOBJECTIF)
);

/*==============================================================*/
/* Table : INDICATEUR                                           */
/*==============================================================*/
create table INDICATEUR
(
   NUMINDIC             int not null,
   NUMACTION            int not null,
   LIBINDIC             char(20),
   POIDS                int,
   primary key (NUMINDIC)
);

/*==============================================================*/
/* Table : JEU                                                  */
/*==============================================================*/
create table JEU
(
   NUMJEU               int not null,
   LIBELLEJEU           char(25),
   primary key (NUMJEU)
);

/*==============================================================*/
/* Table : MISSION                                              */
/*==============================================================*/
create table MISSION
(
   NUMMISSION           int not null,
   LIBMISSION           char(25),
   primary key (NUMMISSION)
);

/*==============================================================*/
/* Table : OBJECTIF                                             */
/*==============================================================*/
create table OBJECTIF
(
   NUMOBJECTIF          int not null,
   NUMMISSION           int,
   LIBOBECTIF           char(25),
   primary key (NUMOBJECTIF)
);

/*==============================================================*/
/* Table : OBTIENT                                              */
/*==============================================================*/
create table OBTIENT
(
   IDUSERS             int NOT NULL,
   DATEJOUR             date not null,
   NUMACTION            int not null,
   VALEURDEBUT          int,
   VALEURFIN            int,
   primary key (IDUSERS, DATEJOUR, NUMACTION)
);

/*==============================================================*/
/* Table : POSSEDE                                              */
/*==============================================================*/
create table POSSEDE
(
   NUMACTION            int not null,
   NUMREGLE             int not null,
   primary key (NUMACTION, NUMREGLE)
);

/*==============================================================*/
/* Table : REGLE                                                */
/*==============================================================*/
create table REGLE
(
   NUMREGLE             int not null,
   LIBREGLE             char(25),
   SCOREMIN             int,
   primary key (NUMREGLE)
);


/*==============================================================*/
/* Table : INSCRIPTION                                          */
/*==============================================================*/
create table INSCRIPTION
(
   NUMJEU               int not null,
   NUMAPPRENANT         int not null,
   DATEINSCRIPTION      date not null,
   primary key (NUMJEU, NUMAPPRENANT)
);


alter table ACTION add constraint FK_A_POUR_SUCCESSEUR foreign key (ACT_NUMACTION)
      references ACTION (NUMACTION) on delete restrict on update restrict;

alter table COMPREND add constraint FK_COMPREND foreign key (NUMJEU)
      references JEU (NUMJEU) on delete restrict on update restrict;

alter table COMPREND add constraint FK_COMPREND2 foreign key (NUMMISSION)
      references MISSION (NUMMISSION) on delete restrict on update restrict;

alter table EST_ASSOCIE add constraint FK_EST_ASSOCIE foreign key (NUMACTION)
      references ACTION (NUMACTION) on delete restrict on update restrict;

alter table EST_ASSOCIE add constraint FK_EST_ASSOCIE2 foreign key (NUMOBJECTIF)
      references OBJECTIF (NUMOBJECTIF) on delete restrict on update restrict;

alter table FIXE add constraint FK_FIXE foreign key (NUMMISSION)
      references MISSION (NUMMISSION) on delete restrict on update restrict;

alter table FIXE add constraint FK_FIXE2 foreign key (NUMOBJECTIF)
      references OBJECTIF (NUMOBJECTIF) on delete restrict on update restrict;

alter table INDICATEUR add constraint FK_EST_VALORISE foreign key (NUMACTION)
      references ACTION (NUMACTION) on delete restrict on update restrict;

alter table OBJECTIF add constraint FK_OBJECTIF foreign key (NUMMISSION)
      references MISSION (NUMMISSION) on delete restrict on update restrict;

alter table OBTIENT add constraint FK_OBTIENT foreign key (IDUSERS)
      references USERS (IDUSERS) on delete restrict on update restrict;

alter table OBTIENT add constraint FK_OBTIENT2 foreign key (DATEJOUR)
      references CALENDRIER (DATEJOUR) on delete restrict on update restrict;

alter table OBTIENT add constraint FK_OBTIENT3 foreign key (NUMACTION)
      references ACTION (NUMACTION) on delete restrict on update restrict;

alter table POSSEDE add constraint FK_POSSEDE foreign key (NUMACTION)
      references ACTION (NUMACTION) on delete restrict on update restrict;

alter table POSSEDE add constraint FK_POSSEDE2 foreign key (NUMREGLE)
      references REGLE (NUMREGLE) on delete restrict on update restrict;

alter table INSCRIPTION add constraint FK_INSCRIPTION foreign key (NUMJEU)
      references JEU (NUMJEU) on delete restrict on update restrict;

alter table INSCRIPTION add constraint FK_INSCRIPTION2 foreign key (NUMAPPRENANT)
      references USERS (IDUSERS) on delete restrict on update restrict;
