import * as React from 'react';
import { StyleSheet, Button, View, Text, TextInput, Pressable, Image, ImageBackground} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import * as Location from 'expo-location';

 let data = [];
 const logo = require('./assets/Logo.png');
 const ajolote = require('./assets/Ajolote.png');
 const calidad = require('./assets/Calidad.png');
 const juncos = require('./assets/juncos.png');
 const lago = require('./assets/Lago.png');
 const pato = require('./assets/Pato.png');
 const splash = require('./assets/splash.png');

function HomeScreen({ navigation }) {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center', backgroundColor: 'paleturquoise'} }>

      
        <Image
        style = {{width: 300, height: 300}}
          source={logo}
        />
        
      <View style={styles.bottonInicio}>
      <Button
        title="Login"   
        onPress={() => navigation.navigate('Login')}
        color={'white'}
      />
    </View>
      <View style={styles.space}></View>

      <View style={styles.bottonInicio}>
      <Button
        title="Sign Up"
        titleStyle={{ fontSize: 1 }}
        onPress={() => navigation.navigate('SignUp')}
        color={'white'}
      />
      </View>
    </View>
  );
}

function LoginScreen({ navigation }) {
  const [email, inputEmail] = React.useState('');
  const [password, inputPassword] = React.useState('');

  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text >
        Login
      </Text>
      <Image
        style = {{width: 300, height: 300}}
          source={ajolote}
        />
      <TextInput
        style={styles.container}
        onChangeText={inputEmail}
        placeholder='E-mail'
        value={email}
      />
      <TextInput
        style={styles.container}
        onChangeText={inputPassword}
        secureTextEntry={true}
        placeholder='Password'
        value={password}
      />
      <Button title="Login" onPress={async () => await Autenticate(email, password, navigation)}/>
      {/* TODO BUTTONDEBUGER */}
      <Button title="Go back" onPress={() => navigation.goBack()} />
    </View>
  );
}
async function Autenticate(UserEmail, UserPassword, navigation){

  const user = {
      id: 1,
      name: 'hey',
      email: UserEmail,
      password: UserPassword
  };

  console.log(JSON.stringify(user));

  const response = await fetch('http://10.72.2.112:8080/user/login/', {
      method: 'POST',
      headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(user)
  });
  console.log(response.status);

  if(response.status == 200){
    navigation.navigate('Permisson');
  }else{
    //Todo Renderiza error
    console.log("NOT VALID");
  }
}


//TODO debuger
const printUserData = (emailValue, passwordValue) => {
 console.log(emailValue); 
 console.log(passwordValue);
};


function SignUpScreen({ navigation }) {
  const [usuario, onChangeText] = React.useState('');
  const [contra, onChangeText1] = React.useState('');
  const [correo, onChangeText2] = React.useState('');
  
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>

      <Image
        style = {{width: 300, height: 300}}
          source={pato}
        />

    <TextInput 
      style={styles.container}
      placeholder='Usuario'
      onChangeText={onChangeText}
      value={usuario}
    />

    <TextInput 
          style={styles.container}
          placeholder='Contraseña'
          onChangeText={onChangeText1}
          value={contra}
    />

    <TextInput 
              style={styles.container}
              placeholder='Correo'
              onChangeText={onChangeText2}
              value={correo}
        />

    <Button title="Sign up" onPress={() => saveToServer(usuario, contra, correo, navigation)} />
    <Button title="Go back" onPress={() => navigation.goBack()} />
    
  </View>
);
}

async function saveToServer(usuario, contra, correo, navigation){
  const user = {
    id: 0,
    name: usuario,
    email: correo,
    password: contra
  };

  console.log(user);

  const response = await fetch('http://10.72.2.112:8080/user/create/', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
    });

    if(response.status == 200){
      navigation.navigate('Login')
    }else{
      console.log("Email already in use")
      //Todo Renderiza error
    }
}

function PermissonScreen({ navigation }) {
  const [location, setLocation] = React.useState(null);
  const [errorMsg, setErrorMsg] = React.useState(null);

  React.useEffect(() => {
    (async () => {
      
      let { status } = await Location.requestForegroundPermissionsAsync();
      if (status !== 'granted') {
        setErrorMsg('Permission to access location was denied');
        return;
      }

      let location = await Location.getCurrentPositionAsync({});
      setLocation(location);
    })();
  }, []);

  let text = 'Waiting..';
  if (errorMsg) {
    text = errorMsg;
    return(
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Text>{text}</Text>
        <Button title="Go back" onPress={() => navigation.navigate('Home')} />
      </View>
    )
  } else if (location) {
    text = JSON.stringify(location);
    lat = location.coords.latitude;
    long = location.coords.longitude;
    handleCoords(lat, long, navigation);

    //todo navigate to main screen
  }
}

async function handleCoords(lat, long, navigation){
  let route = 'http://10.72.2.112:8080/waterbody/listall/'+19.461871335374084+'/'+-99.07601377757437;
  const response = await fetch(route, {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    }
  });

  let json = await response.json();
  data = json;
  console.log(data);
  navigation.navigate('MainPage');
}

function MainPageScreeen( { navigation }){

  return (
      <View style={{width : '100%', height:'90%'}}>
        
        {data.map((item) => {
          return (                            //TODO onPress debería llevar a la pantalla de detalles
            <Pressable style={styles.botton} onPress={() => {
                console.log(item)
                navigation.navigate('InfoTemplate')
                data = item
              }
            }>
              <Text style={styles.Name}>{item.nameWaterBody}</Text>
            </Pressable> 
          );
        })}

        <Image
        style = {{width: 300, height: 300}}
          source={lago}
        />
      </View>
  );
}

function InfoTemplate({ navigation }) {
  return (
    
    <View style={{ flex: 1,fontWeight: 'bold',textShadowColor:'yellow' , backgroundColor: 'paleturquoise', alignItems: 'center', justifyContent: 'center'} }>
        <Text>Tipo de cuerpo de agua:  {data.typeOf}</Text>
        <Text>Nombre : {data.nameWaterBody}</Text>
        <Text>Plantas : {data.plants}</Text>
        <Text>Animales : {data.animals}</Text>
        <Text>Calidad del Agua: {data.waterQuality}</Text>
        <Text>Organización a la que pertenece: {data.organization}</Text>
        <View style={styles.space}>
        </View>
        <Image
        style = {{width: 300, height: 300}}
          source={juncos}
        />
        <Button title="Go back" onPress={() => navigation.goBack()} />
    </View>
  );
}




const Stack = createStackNavigator();

function MyStack() {
  return (
    <Stack.Navigator>
      <Stack.Screen name="Home" component={HomeScreen} />
      <Stack.Screen name="SignUp" component={SignUpScreen} />
      <Stack.Screen name="Login" component={LoginScreen} />
      <Stack.Screen name="Permisson" component={PermissonScreen} />
      <Stack.Screen name="MainPage" component={MainPageScreeen}/>
      <Stack.Screen name="InfoTemplate" component={InfoTemplate}/>
    </Stack.Navigator>
  );
}

const styles = StyleSheet.create({
  space: {
    fwidth: 20,
    height: 20,
  },
  container: {
    backgroundColor: '#fff',
    borderWidth: 1,
    borderColor: '#000',
    padding: 8,
    marginBottom: 10,
    width: '50%'
  },
  paragraph: {
    fontSize: 18,
    textAlign: 'center',
  },
  botton: {
    flex: 0,
    alignItems: 'center',
    borderRadius: 10,
    justifyContent: 'center',
    paddingVertical: 12,
    paddingHorizontal: 35,
    borderRadius: 4,
    elevation: 3,
    backgroundColor: 'darkgreen',
    width: '102%',
    height: '15%',
    marginBottom: 25,
  },

  bottonInicio: {
    flex: 0,
    alignItems: 'center',
    borderRadius: 10,
    justifyContent: 'center',
    paddingVertical: 12,
    paddingHorizontal: 32,
    borderRadius: 4,
    elevation: 3,
    backgroundColor: 'darkgreen',
    width: '36%',
    height: '10%',
    marginBottom: 20,
  },

  buttonText:{
    color: 'white',
    fontWeight: 'bold',
    fontSize: 16,
    textAlign: 'center'
  },

  Name:{
    fontSize: 20,
    color: 'white',
    padding: 20,
    fontSize: 15,
    marginTop: 5,
  },

  icon: {
    tintColor: '#fff',
    height: 16,
    width: 16,
    marginLeft: 5,
    marginRight: 5,
  }
});

export default function App() {
  return (
    <NavigationContainer>
      <MyStack />
    </NavigationContainer>
  );
}