import React from 'react';
import { Text, View, Button ,StyleSheet} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

import TelaLogin from './src/screens/login'
import Telahome from './src/screens/home'
import Explorar from './src/screens/explorar'
import TelaDeEvento from './src/screens/favoritos'
import Telatito from './src/screens/seutito'


function HomeScreen({ navigation }) {
  
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center'}}>
      <Text style={{ fontSize: 40 ,marginBottom:'10'}}>Inicial</Text>

     <Button style={styles.buttonu}
        title="Se Cadastrar"
        onPress={() => navigation.navigate('Cadastro')}
        />
      
       <Button
        title="Login"
        OnPress={() => navigation.navigate('login')}
      />
    </View>
  );
}

const styles = StyleSheet.create({
buttonu:{backgroundColor:'red'},
})

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="login">
        <Stack.Screen name="Home" component={HomeScreen} 
        options={{headerShown:false}}
        />
      
          <Stack.Screen
          name="login"
          component={TelaLogin}
          options={{ headerShown: false }}
          />
           <Stack.Screen
          name="Telahome"
          component={Telahome}
          options={{ headerShown: false }}
          />
            <Stack.Screen
          name="explorar"
          component={Explorar}
          options={{ headerShown: false }}
          />
          <Stack.Screen
          name="favoritos"
          component={TelaDeEvento}
          options={{headerShown:false}}
          />
            <Stack.Screen
          name="seutito"
          component={Telatito}
          options={{headerShown:false}}
          />
          
      </Stack.Navigator>
    </NavigationContainer>
  );
}
