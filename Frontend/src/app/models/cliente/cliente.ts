import { Cuenta } from "../cuenta/cuenta";
import { Usuario } from "../usuario/usuario";

export class Cliente extends Usuario{
    apellido!:string;
    nombre!:string;
    fechaNacimiento!:Date;
    codArea!:number;
    telefono!:number;

    cuenta!:Cuenta;
    amigos!:Array<Cliente>;

}
