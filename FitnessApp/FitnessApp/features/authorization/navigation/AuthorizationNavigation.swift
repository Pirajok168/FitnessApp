//
//  AuthorizationNavigation.swift
//  FitnessApp
//
//  Created by Данила Еремин on 18.05.2024.
//

import Foundation

enum AuthorizationDestination: Hashable {
    case AuthorizationEnterLoginPasswordScreen
}

class AuthorizationNavigation: ObservableObject {
    @Published var path: [AuthorizationDestination] = []
    
    
    func toAuthorizationEnterLoginPasswordScreen(){
        path.append(.AuthorizationEnterLoginPasswordScreen)
    }
    
    func popBackStack(){
        path.removeLast()
    }
}
