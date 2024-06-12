//
//  ContentView.swift
//  ChatPrototype
//
//  Created by Igor Gomes Leandro on 5/14/24.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack(spacing: 25){
            Text("Knock, knock!")
                .padding()
                .background(Color.green, in: RoundedRectangle(cornerRadius:30))
                .shadow(radius: /*@START_MENU_TOKEN@*/10/*@END_MENU_TOKEN@*/)
            Text("Who's there?")
                .padding()
                .background(Color.teal, in: RoundedRectangle(cornerRadius:30))
                .shadow(radius:10)
            Text("it´s me!")
                .padding()
                .background(Color.green, in: RoundedRectangle(cornerRadius:30))
                .shadow(radius:10)
            Text("Me who??")
                .padding()
                .background(Color.teal, in: RoundedRectangle(cornerRadius:30))
                .shadow(radius:10)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
