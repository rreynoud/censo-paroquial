import { Component } from "@angular/core";
import { Http } from "@angular/http";

@Component({
    moduleId: module.id,
    selector: 'listagem',
    templateUrl: './listagem.component.html'
})
export class ListagemComponent{

    fotos: Object[] = [];
    
    constructor(http: Http) {
        console.log('listando fotos')
        http.get('v1/fotos')
        .map(res => res.json()).subscribe(
            fotos => this.fotos = fotos
            
            ,erro => console.log(erro)
        );

        console.log(this.fotos);
    }        
}