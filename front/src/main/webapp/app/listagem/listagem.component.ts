import { Component } from "@angular/core";
import { Http } from "@angular/http";

@Component({
    moduleId: module.id,
    selector: 'listagem',
    templateUrl: './listagem.component.html'
})
export class ListagemComponent{

    familias: Object[] = [];
    
    constructor(http: Http) {
        console.log('listando familias')

        http.get('censo-0.0.1-SNAPSHOT/family')
        .map(res => res.json())
        .subscribe(familias => 
            this.familias = familias 
            ,erro => console.log(erro)
        );

        console.log(this.familias);
    }        
}