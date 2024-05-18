import SwiftUI
import fitness

struct AuthorizationScreen: View {
    @StateObject var viewModel: LocalAuthorizationViewModel = LocalAuthorizationViewModel()
    @ObservedObject private var rootController: AuthorizationNavigation = AuthorizationNavigation()
    

    var body: some View {
        NavigationStack(path: $rootController.path){
            VStack(spacing: 16) {
                VStack{
                    Text("Введите номер телефона")
                        .font(.system(size: 24, weight: .bold, design: .rounded))
                        .frame(maxWidth: .infinity, alignment: .leading)
                    Text("Чтобы войти/зарегистрироваться в приложении")
                        .padding(.top, 5)
                        .font(.system(size: 16, weight: .semibold, design: .rounded))
                        .lineSpacing(3)
                        .foregroundStyle(Color("LightGray"))
                        .frame(maxWidth: .infinity, alignment: .leading)
                }
                Spacer()
                
                
                HStack{
                    Image(systemName: "iphone.gen2")
                    TextField("Номер телефона", text: $viewModel.numberPhone)
                        .onChange(of: viewModel.numberPhone){ oldText, newText in
                            viewModel.obtainEvent(viewEvent: AuthorizationEnterPhoneEvents.InputPhone(value: newText))
                        }
                }
                .padding()
                .background(
                    Color("Surface")
                        .clipShape(RoundedRectangle(cornerRadius: 10.0))
                )
                
                Button(action: {}, label: {
                    Text("Продолжить")
                        .frame(maxWidth: .infinity)
                        .frame(height: 48)
                })
                .background(Color("AccentColor"))
                .foregroundStyle(.white)
                .clipShape(RoundedRectangle(cornerRadius: 10.0))
                
                Button(action: { rootController.toAuthorizationEnterLoginPasswordScreen() }, label: {
                    Text("Другой способ входа")
                        .frame(maxWidth: .infinity)
                        .frame(height: 48)
                })
                .background(RoundedRectangle(cornerRadius: 10).stroke(lineWidth: 1).foregroundColor(Color.black))
                .foregroundStyle(Color("AccentColor"))
                
                
                Button(action: {}, label: {
                    Text("Регистрация")
                        .frame(maxWidth: .infinity)
                        .frame(height: 48)
                })
                
                .foregroundStyle(Color("AccentColor"))
                
                
                Spacer()
            }
            
            .padding()
            .navigationDestination(for: AuthorizationDestination.self) { destation in
                switch destation{
                case .AuthorizationEnterLoginPasswordScreen:
                    AuthorizationEnterLoginPasswordScreen()
                        .environmentObject(rootController)
                }
            }
            
        }
        
        
        
    }
}

#Preview {
    AuthorizationScreen()
}
