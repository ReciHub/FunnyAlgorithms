#include <iostream>
#include <string>
using namespace std;

class Musica{
    public:
    int t, total;
    int id;
    string nome;
    Musica(){
        nome = " ";
        t = -1;
        total = 0;
        id = 0;
    }
    Musica(string n, int temp){
        nome = n;
        t = temp;
        total = 0;
        id = 0;
    }
    string obterNome(){
        return nome;
    }
    int obterTempo(){
        return t;
    }
    int obterTotal(){
        return total;
    }
    int obterId(){
        return id;
    }
    void incrementaTempo(){
        total = total+t;
    }
    void calcularId(string nome){
        for (int i = 0; i < nome.size(); i++)
        id += (int)nome[i]*i;
    }
};

class Hash{
    public:
    int max_itens;
    int max_posicoes;
    int quant_itens;
    Musica* estrutura;
    int funcaoHash (Musica musica){
        return(musica.obterId()%max_posicoes);
    }
    int funcaoHashBusca (Musica musica){
        musica.calcularId(musica.obterNome());
        return(musica.obterId()%max_posicoes);
    }
    Hash(int n){
        quant_itens = 0;
        max_itens = n*0.5;
        max_posicoes = n;
        estrutura = new Musica[n];
        //condicao de aumento de vetor eh qnt_itens >= max itens;
    }
    ~Hash(){
        delete [] estrutura;
    }
    bool estaCheio(){
        return(quant_itens >= (max_itens)+1);
    }
    int oberTamanhoAtual(){
        return(quant_itens);
    } 
    void inserir(Musica musica){
        int local = funcaoHash(musica);
        while(estrutura[local].obterTempo() > 0){
            local = (local+1) % max_posicoes;
        }
        estrutura[local] = musica;
        quant_itens++;
        cout << musica.obterNome() << " " << local << endl;
    }
    void rehash(Musica musica){
        int local = funcaoHash(musica);
        while(estrutura[local].obterTempo() > 0){
            local = (local+1) % max_posicoes;
        }
        estrutura[local] = musica;
        quant_itens++;
    }
    void buscaIncrementa(Musica& musica){
        int local = funcaoHashBusca(musica);
        while (estrutura[local].obterTempo() != -1){
            if (estrutura[local].obterNome()==musica.obterNome()){
                musica = estrutura[local];
                musica.incrementaTempo();
                estrutura[local] = musica;
                cout << estrutura[local].obterNome() << " " << estrutura[local].obterTotal() << endl;
                break;
            } 
            local = (local+1) % max_posicoes;
        }
    }
    void buscaImprime(Musica musica){// 
        int local = funcaoHashBusca(musica);//
        while (estrutura[local].obterTempo() != -1){
            if (estrutura[local].obterNome()==musica.obterNome()){
                cout << estrutura[local].obterNome() << " " << estrutura[local].obterTotal() << endl;
                break;
            } 
            local = (local+1) % max_posicoes;
        }
    }
};

int main(){
    int n;
    string comando, nome;
    int t;
    cin >> n;
    Hash hashtable(n);
    do{
        cin >> comando;
        if (comando=="END"){
           continue;
        }
        else if(comando=="ADD"){
            if (hashtable.estaCheio()){
                int num = hashtable.oberTamanhoAtual();
                Musica* aux = new Musica[num];
                int pos = 0;
                for (int i = 0; i < n; i++){
                    if(hashtable.estrutura[i].t!=-1){
                        aux[pos] = hashtable.estrutura[i];
                        pos++;
                    }
                }
                delete [] hashtable.estrutura;
                n = (n*2)+1;
                hashtable.quant_itens = 0;
                hashtable.max_itens = n*0.5;
                hashtable.max_posicoes = n;
                hashtable.estrutura = new Musica[n];
                //reharshing
                for (int i = 0; i < num; i++){
                    hashtable.rehash(aux[i]);
                }
                delete [] aux;
            }
            cin >> nome >> t;
            Musica musica(nome, t);
            musica.calcularId(musica.obterNome());
            hashtable.inserir(musica);
        }
        else if(comando=="PLAY"){
            cin >> nome;
            Musica musica(nome, 0);
            hashtable.buscaIncrementa(musica);
        }
        else if(comando=="TIME"){
            cin >> nome;
            Musica musica(nome, 0);
            hashtable.buscaImprime(musica);
        }
    } while(comando!="END");
}