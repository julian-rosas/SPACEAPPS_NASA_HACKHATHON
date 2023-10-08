import { StyleSheet, Text, View } from "react-native";
import React from "react";

function printUser() {
    console.log(input);
  }

export default function FlatCard() { 
    return (
        <Text>Flat CARD!</Text>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#fff",
        alignItems: "center",
        justifyContent: 'center',
    },
});