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
        this.familia.sobrenome = '';          
        
        console.log("asdfa.skdflaksjdflkasjdlkfjaslkdfjalksjdflkajsldfkjalskdjf");
        console.log("asdfa.skdflaksjdflkasjdlkfjaslkdfjalksjdflkajsldfkjalskdjf");
        console.log("asdfa.skdflaksjdflkasjdlkfjaslkdfjalksjdflkajsldfkjalskdjf");

        console.log("asdfa.skdflaksjdflkasjdlkfjaslkdfjalksjdflkajsldfkjalskdjf");

    }

    cadastrar(event) {    
        event.preventDefault();
        console.log(this.familia);

        var headers = new Headers();
        headers.append('Content-Type', 'application/json');

        this.familia = new FamiliaComponent();
        this.pessoas = []  ;

        // this.http.post('v1/fotos', JSON.stringify(this.familia), { headers: headers })
        // .subscribe(() => {
        //     this.familia = new FamiliaComponent()
        //     console.log('Familia salva com sucesso');
        // }, erro =>  console.log(erro));
        
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