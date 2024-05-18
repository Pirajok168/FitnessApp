//
//  AuthorizationEnterLoginPasswordScreen.swift
//  FitnessApp
//
//  Created by Данила Еремин on 18.05.2024.
//

import SwiftUI
import fitness

struct AuthorizationEnterLoginPasswordScreen: View {
    @StateObject var viewModel: LocalAuthorizationEnterLoginPasswordViewModel = LocalAuthorizationEnterLoginPasswordViewModel()
    @EnvironmentObject  var rootController: AuthorizationNavigation
    
    var body: some View {
        VStack(spacing: 16) {
            VStack{
                Text("Авторизация")
                    .font(.system(size: 24, weight: .bold, design: .rounded))
                    .frame(maxWidth: .infinity, alignment: .leading)
                Text("Введите логин, который вы использовали при регистрации в мобильном приложении")
                    .padding(.top, 5)
                    .font(.system(size: 16, weight: .semibold, design: .rounded))
                    .lineSpacing(3)
                    .foregroundStyle(Color("LightGray"))
                    .frame(maxWidth: .infinity, alignment: .leading)
            }
            Spacer()
            
            
            HStack{
                
                TextField("Логин", text: $viewModel.login)
                    .onChange(of: viewModel.login){ oldText, newText in
                        viewModel.obtainEvent(viewEvent: AuthorizationEnterLoginPasswordEvents.InputLogin(value: newText))
                    }
            }
            .padding()
            .background(
                Color("Surface")
                    .clipShape(RoundedRectangle(cornerRadius: 10.0))
            )
            
            
            HStack{
                if(viewModel.showPassword){
                    TextField("Пароль", text: $viewModel.password)
                }else {
                    SecureField(text: $viewModel.password, label: {
                        Text("Пароль")
                    })
                }
                
                Button(action: {
                    viewModel.onShowPassword()
                }, label: {
                    Image(systemName: viewModel.showPassword ?  "eye" : "eye.slash")
                })
                
                

            }
            .onChange(of: viewModel.password){ oldText, newText in
                viewModel.obtainEvent(viewEvent: AuthorizationEnterLoginPasswordEvents.InputPassword(value: newText))
            }
            .padding()
            .background(
                Color("Surface")
                    .clipShape(RoundedRectangle(cornerRadius: 10.0))
            )
            
            Button(action: {}, label: {
                Text("Войти")
                    .frame(maxWidth: .infinity)
                    .frame(height: 48)
            })
            .background(Color("AccentColor"))
            .foregroundStyle(.white)
            .clipShape(RoundedRectangle(cornerRadius: 10.0))
            
            Spacer()
        }
        
        .padding()
    }
}

#Preview {
    AuthorizationEnterLoginPasswordScreen()
}
