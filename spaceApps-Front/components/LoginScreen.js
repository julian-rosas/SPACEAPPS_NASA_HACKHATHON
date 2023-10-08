import * as React from 'react';
import { StyleSheet, Button, View, Text, TextInput} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

let input = '';
    function saveLocal(Input){
    input = Input;
    }

export default function LoginScreen({ navigation }) {
    const [inputText, setInputText] = React.useState('');
    const [number, onChangeNumber] = React.useState('');
    
    return (
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <TextInput 
          style={styles.container}
          onChangeText={setInputText}
          value={inputText}
        />
        <Button title="Save" onPress={saveLocal({inputText})} />
        <Button title="Print" onPress={printUser}/>
        <Text>Saved input: {inputText}</Text>
        <Button title="Go back" onPress={() => navigation.goBack()} />
        
      </View>
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
    }
  });