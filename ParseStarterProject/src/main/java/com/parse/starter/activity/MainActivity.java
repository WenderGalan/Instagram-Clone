    /*
     * Copyright (c) 2015-present, Parse, LLC.
     * All rights reserved.
     *
     * This source code is licensed under the BSD-style license found in the
     * LICENSE file in the root directory of this source tree. An additional grant
     * of patent rights can be found in the PATENTS file in the same directory.
     */
    package com.parse.starter.activity;

    import android.content.Context;
    import android.content.Intent;
    import android.graphics.Bitmap;
    import android.net.Uri;
    import android.os.Bundle;
    import android.provider.MediaStore;
    import android.support.v4.content.ContextCompat;
    import android.support.v4.view.ViewPager;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Toast;

    import com.parse.ParseException;
    import com.parse.ParseFile;
    import com.parse.ParseObject;
    import com.parse.ParseUser;
    import com.parse.SaveCallback;
    import com.parse.starter.R;
    import com.parse.starter.adapter.HomeAdapter;
    import com.parse.starter.adapter.TabsAdapter;
    import com.parse.starter.fragments.HomeFragment;
    import com.parse.starter.util.SlidingTabLayout;

    import java.io.ByteArrayInputStream;
    import java.io.ByteArrayOutputStream;
    import java.io.IOException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.HashMap;


    public class MainActivity extends AppCompatActivity{

       private Toolbar toolbarPrincipal;
       private SlidingTabLayout slidingTabLayout;
       private ViewPager viewPager;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configurar toolbar
        toolbarPrincipal = (Toolbar) findViewById(R.id.toolbar_principal);
        toolbarPrincipal.setLogo(R.drawable.instagramlogo);
        setSupportActionBar(toolbarPrincipal);

        //configurar as abas
          slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tab_main);
          viewPager = (ViewPager) findViewById(R.id.view_pager_main);

          //configurar adapter
          TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), this);
          viewPager.setAdapter(tabsAdapter);
          slidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.text_item_tab);
          slidingTabLayout.setDistributeEvenly(true);
          slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.cinzaEscuro));
          slidingTabLayout.setViewPager(viewPager);


    //FILTROS, CONSULTA E INSERÇÃO DE DADOS NO PARSE
//        //INSERINDO DADOS
//        /*ParseObject pontuacao = new ParseObject("Pontuacao");
//        pontuacao.put("nome", "Maria");
//        pontuacao.put("pontos", 150);
//        pontuacao.saveInBackground(new SaveCallback() {
//          @Override
//          public void done(ParseException e) {
//            if (e == null){
//              //nao temos erro
//              Log.i("Informações", "Dados salvos com sucesso!");
//            }else{
//              Log.i("Informações", "Erro ao salvar os dados");
//            }
//          }
//        });*/
//
//        //ATUALIZANDO DADOS
//        /*ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");
//        consulta.getInBackground("a6qaqHE5Gs", new GetCallback<ParseObject>() {
//          @Override
//          public void done(ParseObject object, ParseException e) {
//            if (e == null){
//              //podemos atualizar aqui o objectId
//
//              object.put("pontos", 1300);
//              object.saveInBackground();
//              Log.i("consultaObjeto", "Atualizado com sucesso!");
//
//            }else{
//              Log.i("consultaObjeto", "Erro ao consultar objeto");
//            }
//          }
//        });*/
//
//        //FILTRANDO DADOS
//        //ParseQuery<ParseObject> filtro = ParseQuery.getQuery("Pontuacao");
//
//              //aplicando filtros na listagem dos dados
//              //filtro.whereGreaterThan("pontos", 800);
//              //filtro.whereGreaterThanOrEqualTo("pontos", 100);
//              //filtro.whereLessThan("pontos", 500);
//              //filtro.whereStartsWith("nome", "Jo");
//              //filtro.whereEndsWith("nome", "ia");
//              //filtro.addAscendingOrder("pontos");
//              //filtro.addDescendingOrder("pontos");
//              //filtro.setLimit(1);
//
//            //listar os dados
//            /*filtro.findInBackground(new FindCallback<ParseObject>() {
//                @Override
//                public void done(List<ParseObject> objects, ParseException e) {
//                    if (e == null){//efetuada a listagem sem erros
//                        Log.i("consultaObjeto", "Sucesso ao listar os objetos " + objects.size());
//
//                        for (ParseObject object : objects){
//                            Log.i("consultaObjeto", "Objetos - Nome: " + object.get("nome") + "       Pontos: " + object.get("pontos") );
//                        }
//
//                    }else{
//                        Log.i("consultaObjeto", "Erro ao consultar objeto " + e.getMessage());
//                    }
//                }
//            });*/

        /**CADASTRO DE USUARIO**/
//          ParseUser usuario = new ParseUser();
//          usuario.setUsername("wendergalan");
//          usuario.setPassword("123456");
//          usuario.setEmail("wendergalan2014@hotmail.com");

          /**CADASTRAR O USUARIO**/
//          usuario.signUpInBackground(new SignUpCallback() {
//              @Override
//              public void done(ParseException e) {
//                  if (e == null){//deu certo
//                      Log.i("cadastroUsuario", "Sucesso ao cadastrar usuario!");
//                  }else{
//                      Log.i("cadastroUsuario", "Erro ao cadastrar usuario! " + e.getMessage());
//                  }
//              }
//          });

        /**VERIFICAR USUARIO LOGADO**/
            //DESLOGAR USUARIO
//          ParseUser.logOut();
//
//
//          if (ParseUser.getCurrentUser() != null){//usuario logado
//              Log.i("LoginUsuario", "Usuario está logado!");
//          }else{//usuario nao esta logado
//              Log.i("LoginUsuario", "Usuario não está logado!");
//          }

        /**LOGIN DO USUARIO**/
//        ParseUser.logInInBackground("wendergalan", "123456789", new LogInCallback() {
//            @Override
//            public void done(ParseUser user, ParseException e) {
//                if (e == null){//deu certo
//                    Log.i("verificarLoginUsuario", "Login realizado com sucesso");
//                }else{//erro
//                    Log.i("verificarLoginUsuario", "Login não realizado com sucesso " + e.getMessage());
//                }
//            }
//        });


      }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
          MenuInflater inflater = getMenuInflater();
          inflater.inflate(R.menu.menu_main, menu);
          return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
          switch (item.getItemId()){
              case R.id.action_sair:
                  //fazer algo
                  deslogarUsuario();
                  return true;
              case R.id.action_configuracoes:
                  return true;
              case R.id.action_compartilhar:
                  compartilharFoto();
                  return true;
              default:
                  return super.onOptionsItemSelected(item);
          }

        }

        private void deslogarUsuario(){
            ParseUser.logOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }


        private void compartilharFoto(){
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 1);


        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            //testar o processo de retorno dos dados
            if (requestCode == 1 && resultCode == RESULT_OK && data != null){
                //recuperar local do recurso
                Uri localImagemSelecionada = data.getData();

                //recupera a imagem do local selecionado
                try {
                    Bitmap imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionada);

                    //comprimir a imagem no formato PNG
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    imagem.compress(Bitmap.CompressFormat.JPEG, 50, stream);

                    //cria um array de byte da imagem
                    byte[] byteArray = stream.toByteArray();

                    //Cria um arquivo com formato do proprio parse
                    SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmaaaahhmmss");
                    String nomeImagem = dateFormat.format(new Date());
                    ParseFile arquivoParse = new ParseFile(nomeImagem + "Imagem.png", byteArray);

                    //Monta pbjeto para salvar no parse
                    ParseObject parseObject = new ParseObject("Imagem");
                    parseObject.put("username", ParseUser.getCurrentUser().getUsername());
                    parseObject.put("imagem", arquivoParse);

                    //salvar os dados
                    parseObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null){//sucesso
                                Toast.makeText(getApplicationContext(), "Sua imagem foi postada!", Toast.LENGTH_LONG).show();

                                //atualizar o fragmento Home
                                TabsAdapter adapterNovo = (TabsAdapter)  viewPager.getAdapter();
                                HomeFragment homeFragment = (HomeFragment) adapterNovo.getFragment(0);
                                homeFragment.atualizaPostagens();

                            }else{//erro
                                Toast.makeText(getApplicationContext(), "Erro ao postar sua imagem, tente novamente!", Toast.LENGTH_LONG).show();
                                Log.i("Erro", e.getMessage());
                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
