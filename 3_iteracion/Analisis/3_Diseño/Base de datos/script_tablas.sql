SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `touchteam` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `touchteam`;

-- -----------------------------------------------------
-- Table `touchteam`.`seccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`seccion` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`seccion` (
  `seccion_id` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`seccion_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`carta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`carta` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`carta` (
  `carta_id` INT NOT NULL AUTO_INCREMENT ,
  `ultima_modificacion` DATE NULL ,
  PRIMARY KEY (`carta_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`tieneSeccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`tieneSeccion` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`tieneSeccion` (
  `seccion_seccion_id` INT NOT NULL ,
  `carta_carta_id` INT NOT NULL ,
  PRIMARY KEY (`seccion_seccion_id`) ,
  CONSTRAINT `fk_tieneSeccion_carta`
    FOREIGN KEY (`carta_carta_id` )
    REFERENCES `touchteam`.`carta` (`carta_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tieneSeccion_seccion1`
    FOREIGN KEY (`seccion_seccion_id` )
    REFERENCES `touchteam`.`seccion` (`seccion_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tieneSeccion_carta` ON `touchteam`.`tieneSeccion` (`carta_carta_id` ASC) ;

CREATE INDEX `fk_tieneSeccion_seccion1` ON `touchteam`.`tieneSeccion` (`seccion_seccion_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`seccionComida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`seccionComida` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`seccionComida` (
  `seccion_seccion_id` INT NOT NULL ,
  PRIMARY KEY (`seccion_seccion_id`) ,
  CONSTRAINT `fk_seccionComida_seccion1`
    FOREIGN KEY (`seccion_seccion_id` )
    REFERENCES `touchteam`.`seccion` (`seccion_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_seccionComida_seccion1` ON `touchteam`.`seccionComida` (`seccion_seccion_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`seccionBebida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`seccionBebida` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`seccionBebida` (
  `seccion_seccion_id` INT NOT NULL ,
  PRIMARY KEY (`seccion_seccion_id`) ,
  CONSTRAINT `fk_seccionBebida_seccion1`
    FOREIGN KEY (`seccion_seccion_id` )
    REFERENCES `touchteam`.`seccion` (`seccion_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_seccionBebida_seccion1` ON `touchteam`.`seccionBebida` (`seccion_seccion_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`elemento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`elemento` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`elemento` (
  `elemento_id` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `descripcion` VARCHAR(180) NULL ,
  `disponible` TINYINT(1) NULL ,
  `foto` BLOB NULL ,
  `divi` INT NULL ,
  `divi_max` INT NULL ,
  `precio` FLOAT NULL ,
  PRIMARY KEY (`elemento_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`elementoBebida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`elementoBebida` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`elementoBebida` (
  `elemento_elemento_id` INT NOT NULL ,
  PRIMARY KEY (`elemento_elemento_id`) ,
  CONSTRAINT `fk_elementoBebida_elemento1`
    FOREIGN KEY (`elemento_elemento_id` )
    REFERENCES `touchteam`.`elemento` (`elemento_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_elementoBebida_elemento1` ON `touchteam`.`elementoBebida` (`elemento_elemento_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`elementoPlato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`elementoPlato` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`elementoPlato` (
  `elemento_elemento_id` INT NOT NULL ,
  `tiempo_elaboracion` INT NULL ,
  PRIMARY KEY (`elemento_elemento_id`) ,
  CONSTRAINT `fk_elementoComida_elemento1`
    FOREIGN KEY (`elemento_elemento_id` )
    REFERENCES `touchteam`.`elemento` (`elemento_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_elementoComida_elemento1` ON `touchteam`.`elementoPlato` (`elemento_elemento_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`producto` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`producto` (
  `producto_id` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `cantidad` INT NULL ,
  `maximo` INT NULL ,
  `minimo` INT NULL ,
  `foto` BLOB NULL ,
  PRIMARY KEY (`producto_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`productoIngrediente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`productoIngrediente` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`productoIngrediente` (
  `producto_producto_id` INT NOT NULL ,
  PRIMARY KEY (`producto_producto_id`) ,
  CONSTRAINT `fk_productoIngrediente_producto1`
    FOREIGN KEY (`producto_producto_id` )
    REFERENCES `touchteam`.`producto` (`producto_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_productoIngrediente_producto1` ON `touchteam`.`productoIngrediente` (`producto_producto_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`productoBebida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`productoBebida` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`productoBebida` (
  `producto_producto_id` INT NOT NULL ,
  PRIMARY KEY (`producto_producto_id`) ,
  CONSTRAINT `fk_productoBebida_producto1`
    FOREIGN KEY (`producto_producto_id` )
    REFERENCES `touchteam`.`producto` (`producto_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_productoBebida_producto1` ON `touchteam`.`productoBebida` (`producto_producto_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`tieneBebida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`tieneBebida` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`tieneBebida` (
  `elementoBebida_elemento_elemento_id` INT NOT NULL ,
  `productoBebida_producto_producto_id` INT NOT NULL ,
  `cantidad` FLOAT NULL ,
  PRIMARY KEY (`elementoBebida_elemento_elemento_id`, `productoBebida_producto_producto_id`) ,
  CONSTRAINT `fk_tieneBebida_elementoBebida1`
    FOREIGN KEY (`elementoBebida_elemento_elemento_id` )
    REFERENCES `touchteam`.`elementoBebida` (`elemento_elemento_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tieneBebida_productoBebida1`
    FOREIGN KEY (`productoBebida_producto_producto_id` )
    REFERENCES `touchteam`.`productoBebida` (`producto_producto_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tieneBebida_elementoBebida1` ON `touchteam`.`tieneBebida` (`elementoBebida_elemento_elemento_id` ASC) ;

CREATE INDEX `fk_tieneBebida_productoBebida1` ON `touchteam`.`tieneBebida` (`productoBebida_producto_producto_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`tieneIngrediente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`tieneIngrediente` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`tieneIngrediente` (
  `elementoComida_elemento_elemento_id` INT NOT NULL ,
  `productoIngrediente_producto_producto_id` INT NOT NULL ,
  `cantidad` FLOAT NULL ,
  PRIMARY KEY (`elementoComida_elemento_elemento_id`, `productoIngrediente_producto_producto_id`) ,
  CONSTRAINT `fk_tieneIngrediente_elementoComida1`
    FOREIGN KEY (`elementoComida_elemento_elemento_id` )
    REFERENCES `touchteam`.`elementoPlato` (`elemento_elemento_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tieneIngrediente_productoIngrediente1`
    FOREIGN KEY (`productoIngrediente_producto_producto_id` )
    REFERENCES `touchteam`.`productoIngrediente` (`producto_producto_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tieneIngrediente_elementoComida1` ON `touchteam`.`tieneIngrediente` (`elementoComida_elemento_elemento_id` ASC) ;

CREATE INDEX `fk_tieneIngrediente_productoIngrediente1` ON `touchteam`.`tieneIngrediente` (`productoIngrediente_producto_producto_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`incidencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`incidencia` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`incidencia` (
  `incidencia_id` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  `fecha` DATETIME NULL ,
  `cantidad_afectada` INT NULL ,
  PRIMARY KEY (`incidencia_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`pedidoProveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`pedidoProveedor` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`pedidoProveedor` (
  `pedido_proveedor_id` INT NOT NULL AUTO_INCREMENT ,
  `fecha_pedido` DATE NULL ,
  `recibido` TINYINT(1) NULL ,
  PRIMARY KEY (`pedido_proveedor_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`tieneIncidencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`tieneIncidencia` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`tieneIncidencia` (
  `incidencia_incidencia_id` INT NOT NULL ,
  `producto_producto_id` INT NOT NULL ,
  `cantidad` FLOAT NULL ,
  PRIMARY KEY (`incidencia_incidencia_id`) ,
  CONSTRAINT `fk_tieneIncidencia_incidencia1`
    FOREIGN KEY (`incidencia_incidencia_id` )
    REFERENCES `touchteam`.`incidencia` (`incidencia_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tieneIncidencia_producto1`
    FOREIGN KEY (`producto_producto_id` )
    REFERENCES `touchteam`.`producto` (`producto_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tieneIncidencia_incidencia1` ON `touchteam`.`tieneIncidencia` (`incidencia_incidencia_id` ASC) ;

CREATE INDEX `fk_tieneIncidencia_producto1` ON `touchteam`.`tieneIncidencia` (`producto_producto_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`tienePedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`tienePedido` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`tienePedido` (
  `pedidoProveedor_pedido_proveedor_id` INT NOT NULL ,
  `producto_producto_id` INT NOT NULL ,
  `cantidad` FLOAT NULL ,
  PRIMARY KEY (`pedidoProveedor_pedido_proveedor_id`, `producto_producto_id`) ,
  CONSTRAINT `fk_tienePedido_pedidoProveedor1`
    FOREIGN KEY (`pedidoProveedor_pedido_proveedor_id` )
    REFERENCES `touchteam`.`pedidoProveedor` (`pedido_proveedor_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tienePedido_producto1`
    FOREIGN KEY (`producto_producto_id` )
    REFERENCES `touchteam`.`producto` (`producto_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tienePedido_pedidoProveedor1` ON `touchteam`.`tienePedido` (`pedidoProveedor_pedido_proveedor_id` ASC) ;

CREATE INDEX `fk_tienePedido_producto1` ON `touchteam`.`tienePedido` (`producto_producto_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`incluyeBebida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`incluyeBebida` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`incluyeBebida` (
  `seccionBebida_seccion_seccion_id` INT NOT NULL ,
  `elementoBebida_elemento_elemento_id` INT NOT NULL ,
  PRIMARY KEY (`seccionBebida_seccion_seccion_id`, `elementoBebida_elemento_elemento_id`) ,
  CONSTRAINT `fk_incluyeBebida_seccionBebida1`
    FOREIGN KEY (`seccionBebida_seccion_seccion_id` )
    REFERENCES `touchteam`.`seccionBebida` (`seccion_seccion_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_incluyeBebida_elementoBebida1`
    FOREIGN KEY (`elementoBebida_elemento_elemento_id` )
    REFERENCES `touchteam`.`elementoBebida` (`elemento_elemento_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_incluyeBebida_seccionBebida1` ON `touchteam`.`incluyeBebida` (`seccionBebida_seccion_seccion_id` ASC) ;

CREATE INDEX `fk_incluyeBebida_elementoBebida1` ON `touchteam`.`incluyeBebida` (`elementoBebida_elemento_elemento_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`incluyePlato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`incluyePlato` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`incluyePlato` (
  `seccionComida_seccion_seccion_id` INT NOT NULL ,
  `elementoPlato_elemento_elemento_id` INT NOT NULL ,
  PRIMARY KEY (`seccionComida_seccion_seccion_id`, `elementoPlato_elemento_elemento_id`) ,
  CONSTRAINT `fk_incluyePlato_seccionComida1`
    FOREIGN KEY (`seccionComida_seccion_seccion_id` )
    REFERENCES `touchteam`.`seccionComida` (`seccion_seccion_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_incluyePlato_elementoPlato1`
    FOREIGN KEY (`elementoPlato_elemento_elemento_id` )
    REFERENCES `touchteam`.`elementoPlato` (`elemento_elemento_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_incluyePlato_seccionComida1` ON `touchteam`.`incluyePlato` (`seccionComida_seccion_seccion_id` ASC) ;

CREATE INDEX `fk_incluyePlato_elementoPlato1` ON `touchteam`.`incluyePlato` (`elementoPlato_elemento_elemento_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`elementoPedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`elementoPedido` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`elementoPedido` (
  `elementoPedido_id` INT NOT NULL ,
  `estado` INT NULL ,
  `comentario` VARCHAR(45) NULL ,
  PRIMARY KEY (`elementoPedido_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`elementoColaCocina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`elementoColaCocina` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`elementoColaCocina` (
  `elementoPedido_elementoPedido_id` INT NOT NULL ,
  PRIMARY KEY (`elementoPedido_elementoPedido_id`) ,
  CONSTRAINT `fk_elementoColaCocina_elementoPedido1`
    FOREIGN KEY (`elementoPedido_elementoPedido_id` )
    REFERENCES `touchteam`.`elementoPedido` (`elementoPedido_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_elementoColaCocina_elementoPedido1` ON `touchteam`.`elementoColaCocina` (`elementoPedido_elementoPedido_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`elementoColaBar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`elementoColaBar` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`elementoColaBar` (
  `elementoPedido_elementoPedido_id` INT NOT NULL ,
  PRIMARY KEY (`elementoPedido_elementoPedido_id`) ,
  CONSTRAINT `fk_elementoColaBar_elementoPedido1`
    FOREIGN KEY (`elementoPedido_elementoPedido_id` )
    REFERENCES `touchteam`.`elementoPedido` (`elementoPedido_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_elementoColaBar_elementoPedido1` ON `touchteam`.`elementoColaBar` (`elementoPedido_elementoPedido_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`restaurante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`restaurante` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`restaurante` (
  `restaurante_id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `cif` VARCHAR(45) NULL ,
  `direccion` VARCHAR(90) NULL ,
  `telefono` VARCHAR(20) NULL ,
  PRIMARY KEY (`restaurante_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`factura` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`factura` (
  `factura_id` INT NOT NULL ,
  `estado` INT NULL ,
  `fecha` DATETIME NULL ,
  PRIMARY KEY (`factura_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`pedido` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`pedido` (
  `pedido_id` INT NOT NULL ,
  `mesa_id` INT NULL ,
  `estado` INT NULL ,
  `fecha` DATETIME NULL ,
  PRIMARY KEY (`pedido_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `touchteam`.`facturaPedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`facturaPedido` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`facturaPedido` (
  `pedido_pedido_id` INT NOT NULL ,
  `factura_factura_id` INT NOT NULL ,
  PRIMARY KEY (`pedido_pedido_id`) ,
  CONSTRAINT `fk_facturaPedido_pedido1`
    FOREIGN KEY (`pedido_pedido_id` )
    REFERENCES `touchteam`.`pedido` (`pedido_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturaPedido_factura1`
    FOREIGN KEY (`factura_factura_id` )
    REFERENCES `touchteam`.`factura` (`factura_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_facturaPedido_pedido1` ON `touchteam`.`facturaPedido` (`pedido_pedido_id` ASC) ;

CREATE INDEX `fk_facturaPedido_factura1` ON `touchteam`.`facturaPedido` (`factura_factura_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`tieneElemento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`tieneElemento` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`tieneElemento` (
  `elementoPedido_elementoPedido_id` INT NOT NULL ,
  `pedido_pedido_id` INT NOT NULL ,
  PRIMARY KEY (`elementoPedido_elementoPedido_id`) ,
  CONSTRAINT `fk_tieneElemento_pedido1`
    FOREIGN KEY (`pedido_pedido_id` )
    REFERENCES `touchteam`.`pedido` (`pedido_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tieneElemento_elementoPedido1`
    FOREIGN KEY (`elementoPedido_elementoPedido_id` )
    REFERENCES `touchteam`.`elementoPedido` (`elementoPedido_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tieneElemento_pedido1` ON `touchteam`.`tieneElemento` (`pedido_pedido_id` ASC) ;

CREATE INDEX `fk_tieneElemento_elementoPedido1` ON `touchteam`.`tieneElemento` (`elementoPedido_elementoPedido_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`asociaBebida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`asociaBebida` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`asociaBebida` (
  `elementoColaBar_elementoPedido_elementoPedido_id` INT NOT NULL ,
  `elementoBebida_elemento_elemento_id` INT NOT NULL ,
  PRIMARY KEY (`elementoColaBar_elementoPedido_elementoPedido_id`) ,
  CONSTRAINT `fk_asociaBebida_elementoBebida1`
    FOREIGN KEY (`elementoBebida_elemento_elemento_id` )
    REFERENCES `touchteam`.`elementoBebida` (`elemento_elemento_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asociaBebida_elementoColaBar1`
    FOREIGN KEY (`elementoColaBar_elementoPedido_elementoPedido_id` )
    REFERENCES `touchteam`.`elementoColaBar` (`elementoPedido_elementoPedido_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_asociaBebida_elementoBebida1` ON `touchteam`.`asociaBebida` (`elementoBebida_elemento_elemento_id` ASC) ;

CREATE INDEX `fk_asociaBebida_elementoColaBar1` ON `touchteam`.`asociaBebida` (`elementoColaBar_elementoPedido_elementoPedido_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`asociaPlato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`asociaPlato` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`asociaPlato` (
  `elementoColaCocina_elementoPedido_elementoPedido_id` INT NOT NULL ,
  `elementoPlato_elemento_elemento_id` INT NOT NULL ,
  PRIMARY KEY (`elementoColaCocina_elementoPedido_elementoPedido_id`) ,
  CONSTRAINT `fk_asociaPlato_elementoPlato1`
    FOREIGN KEY (`elementoPlato_elemento_elemento_id` )
    REFERENCES `touchteam`.`elementoPlato` (`elemento_elemento_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asociaPlato_elementoColaCocina1`
    FOREIGN KEY (`elementoColaCocina_elementoPedido_elementoPedido_id` )
    REFERENCES `touchteam`.`elementoColaCocina` (`elementoPedido_elementoPedido_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_asociaPlato_elementoPlato1` ON `touchteam`.`asociaPlato` (`elementoPlato_elemento_elemento_id` ASC) ;

CREATE INDEX `fk_asociaPlato_elementoColaCocina1` ON `touchteam`.`asociaPlato` (`elementoColaCocina_elementoPedido_elementoPedido_id` ASC) ;


-- -----------------------------------------------------
-- Table `touchteam`.`tieneFactura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `touchteam`.`tieneFactura` ;

CREATE  TABLE IF NOT EXISTS `touchteam`.`tieneFactura` (
  `factura_factura_id` INT NOT NULL ,
  `restaurante_restaurante_id` INT NOT NULL ,
  PRIMARY KEY (`factura_factura_id`) ,
  CONSTRAINT `fk_tieneFactura_restaurante1`
    FOREIGN KEY (`restaurante_restaurante_id` )
    REFERENCES `touchteam`.`restaurante` (`restaurante_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tieneFactura_factura1`
    FOREIGN KEY (`factura_factura_id` )
    REFERENCES `touchteam`.`factura` (`factura_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tieneFactura_restaurante1` ON `touchteam`.`tieneFactura` (`restaurante_restaurante_id` ASC) ;

CREATE INDEX `fk_tieneFactura_factura1` ON `touchteam`.`tieneFactura` (`factura_factura_id` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
