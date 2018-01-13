import { Component  } from "@angular/core";
import { FotoComponent } from "../foto/foto.component";
import { Http, Headers } from "@angular/http";
import { FamiliaComponent } from "../familia/familia.component";
import { PessoaComponent } from "../pessoa/pessoa.component";


@Component({
    moduleId: module.id,
    selector: 'cadastro', 
    templateUrl: './cadastro.component.html'
})
export class CadastroComponent {
    
    familia:  FamiliaComponent = new FamiliaComponent();
    pessoas: PessoaComponent[] = [] ;
    integrante: PessoaComponent = new PessoaComponent();
    http: Http;

    constructor(http: Http){
        this.http = http;

        this.familia.enderecoNumero = '';
        this.familia.enderecoRua = '';
        this.familia.enderecoTipo = '';
        this.familia.sobreNome = '';          

        console.log('listando familias')
        http.get('censo-0.0.1-SNAPSHOT/family')
        .map(res => res.json()).subscribe(
            fotos => console.log(JSON.stringify(fotos))       
            ,erro => console.log(erro)
        );

    }

    cadastrar(event) {    
        event.preventDefault();
        console.log('familia a ser salva');
        console.log(this.familia);
        console.log(JSON.stringify(this.familia));

        var headers = new Headers();
        headers.append('Content-Type', 'application/json');

        this.http.post('censo-0.0.1-SNAPSHOT/family', JSON.stringify(this.familia), { headers: headers })
        .subscribe(() => {
            this.familia = new FamiliaComponent()
            console.log('Familia salva com sucesso');
            this.familia = new FamiliaComponent();
            this.pessoas = []  ;
                
        }, erro =>  console.log( 'Erro ao tentar salvar familia: ' + erro));
        
    }    

    adicionarIntegrante(event){
        event.preventDefault();
        console.log(this.familia);
        
        var integranteAUX:PessoaComponent = new PessoaComponent();
        integranteAUX.dataNascimento = this.integrante.dataNascimento;
        integranteAUX.nome = this.integrante.nome;

        this.pessoas.push(integranteAUX);
        this.familia.integrantes.push(integranteAUX);
        
        this.integrante = new PessoaComponent();

    }
}