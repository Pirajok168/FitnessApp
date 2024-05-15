import SwiftUI
import fitness

struct AuthorizationScreen: View {
    @StateObject var viewModel: LocalAuthorizationViewModel = LocalAuthorizationViewModel()
    var body: some View {
        ScrollView {
            TextField("Логин", text: $viewModel.login)
                .textFieldStyle(.roundedBorder)
                .onChange(of: viewModel.login){ oldText, newText in
                    viewModel.obtainEvent(viewEvent: AuthorizationEvents.InputLogin(value: newText))
                }
                
            
            TextField("Пароль", text: $viewModel.password)
                .textFieldStyle(.roundedBorder)
                .onChange(of: viewModel.password){ oldText, newText in
                    viewModel.obtainEvent(viewEvent: AuthorizationEvents.InputPassword(value: newText))
                }
                
        }
    }
}

#Preview {
    AuthorizationScreen()
}
