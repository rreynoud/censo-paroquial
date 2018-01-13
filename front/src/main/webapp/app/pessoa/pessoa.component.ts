import { Component, Input } from "@angular/core";

@Component({
    moduleId: module.id,
    selector: 'pessoa',
    templateUrl: './pessoa.component.html'
})
export class PessoaComponent{
    @Input() name: string;
    @Input() genero: string;
    @Input() dataNascimento: string;
}