import { Factura } from "../factura/factura";
import { Producto } from "../producto/producto";

export class Cuenta {
    nickname!:string;
    saldo!:number;
    fotoPerfil!:string;

    biblioteca!:Array<Producto>;
    carrito!:Array<Producto>;
    facturas!:Array<Factura>;
}
