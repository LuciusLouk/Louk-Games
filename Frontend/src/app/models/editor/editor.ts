import { Producto } from "../producto/producto";
import { Usuario } from "../usuario/usuario";

export class Editor extends Usuario{

    nombreEmpresa!:string;
    tipoEmpresa!:string;
    direccion!: string;
    localidad!: string;
    estadoProvincia!: string;
    codPostal!: number;
    productos!: Array<Producto>;
}
