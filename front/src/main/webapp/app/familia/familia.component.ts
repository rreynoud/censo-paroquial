import { Component, Input } from "@angular/core";
import { PessoaComponent } from "../pessoa/pessoa.component";

@Component({
    moduleId: module.id,
    selector: 'familia',
    templateUrl: './familia.component.html'
})
export class FamiliaComponent{


    @Input() sobreNome: string = '';
    @Input() enderecoRua: string = '';
    @Input() enderecoNumero: string = '';
    @Input() enderecoTipo: string = '';
    @Input() persons: PessoaComponent[] = [] ;
    
    
}